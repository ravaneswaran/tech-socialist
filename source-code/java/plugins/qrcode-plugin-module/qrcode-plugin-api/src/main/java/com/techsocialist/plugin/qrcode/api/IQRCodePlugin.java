package com.techsocialist.plugin.qrcode.api;

import java.awt.image.BufferedImage;

public interface IQRCodePlugin {

    public BufferedImage createImage(String data, String charset, int imageWidth, int imageHeight) throws Exception;

    public String scanImage(BufferedImage bufferedImage) throws Exception;

}
