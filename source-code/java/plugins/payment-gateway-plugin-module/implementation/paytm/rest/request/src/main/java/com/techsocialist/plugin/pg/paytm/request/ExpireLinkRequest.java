package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class ExpireLinkRequest extends AbstractPaytmLinkRequest {

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/link/expire";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/link/expire";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());

        JSONObject head = new JSONObject();

        head.put("tokenType", this.tokenType);
        head.put("signature", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("linkId", this.linkId);

        return body;
    }
}
