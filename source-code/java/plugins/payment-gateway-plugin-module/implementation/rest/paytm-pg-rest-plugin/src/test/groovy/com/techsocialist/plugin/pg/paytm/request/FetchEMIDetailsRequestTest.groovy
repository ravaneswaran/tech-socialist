package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class FetchEMIDetailsRequestTest extends Specification{

    def "test data head"(){
        setup:
        FetchEMIDetailRequest paytmRequest = new FetchEMIDetailRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.dataHead()
    }
    def "test data body"(){
        setup:
        FetchEMIDetailRequest paytmRequest = new FetchEMIDetailRequest()
        String[] channelCode = ["channel-code-001"]

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001").setChannelCodes(channelCode)

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"(){
        setup:
        FetchEMIDetailRequest paytmRequest = new FetchEMIDetailRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw-stage.paytm.in/theia/api/v1/fetchEMIDetail?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"(){
        setup:
        FetchEMIDetailRequest paytmRequest = new FetchEMIDetailRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw.paytm.in/theia/api/v1/fetchEMIDetail?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }

}
