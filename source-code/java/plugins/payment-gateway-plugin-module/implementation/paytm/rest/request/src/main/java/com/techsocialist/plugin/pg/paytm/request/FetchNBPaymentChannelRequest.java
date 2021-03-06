package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class FetchNBPaymentChannelRequest extends AbstractPaytmRequest {

    private String type;

    @Override
    public String url(boolean production) {
        return String.format("%s/%s/fetchNBPaymentChannels?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getVersion(),  this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();

        head.put("clientId", this.getClientId());
        head.put("version", this.getVersion());
        head.put("requestTimestamp", this.getRequestTimestamp());
        head.put("channelId", this.getChannelId());
        head.put("txnToken", this.getTransactionToken());

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();
        body.put("type", this.type);

        return body;
    }

    public FetchNBPaymentChannelRequest setType(String type) {
        this.type = type;
        return this;
    }
}
