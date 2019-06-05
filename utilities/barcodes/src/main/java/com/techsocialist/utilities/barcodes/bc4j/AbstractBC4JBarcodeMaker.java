package com.techsocialist.utilities.barcodes.bc4j;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.techsocialist.utilities.barcodes.api.IBarcodeMaker;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public abstract class AbstractBC4JBarcodeMaker implements IBarcodeMaker {

	protected File getFile(AbstractBarcodeBean barcodeBean, String data,
			String directoryPath) throws IOException {
		final int dpi = 150;
		barcodeBean.setModuleWidth(UnitConv.in2mm(1.0f / dpi));
		String fileName = String.format("barcode-%s.png", new Date().getTime());
		File outputFile = new File(directoryPath + "/" +  fileName);
		OutputStream out = new FileOutputStream(outputFile);
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(out,
				"image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		barcodeBean.generateBarcode(canvas, data);
		canvas.finish();
		out.close();
		return outputFile;
	}
}
