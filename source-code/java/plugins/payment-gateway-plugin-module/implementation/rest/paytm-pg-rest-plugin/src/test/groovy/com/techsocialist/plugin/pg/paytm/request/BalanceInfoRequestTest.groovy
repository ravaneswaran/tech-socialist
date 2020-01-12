package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class BalanceInfoRequestTest extends Specification{

    def "test data head"(){
        setup:
        BalanceInfoRequest paytmRequest = new BalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB").setPaymentMode("submit");
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.dataHead()
    }
    def "test data body"(){
        setup:
        BalanceInfoRequest paytmRequest = new BalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB").setPaymentMode("submit");
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"(){
        setup:
        BalanceInfoRequest paytmRequest = new BalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB").setPaymentMode("submit");
        paytmRequest.setTransactionToken("txn-001")

        then:
            "https://securegw-stage.paytm.in/userAsset/fetchBalanceInfo?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"(){
        setup:
        BalanceInfoRequest paytmRequest = new BalanceInfoRequest();

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB").setPaymentMode("submit");
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw.paytm.in/userAsset/fetchBalanceInfo?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }
}
