package com.techsocialist.plugin.pg.paytm.request


import org.json.JSONObject
import spock.lang.Specification

class TransactionStatusRequestTest extends Specification {

    def "test TransactionStatusRequest data com.techsocialist.plugin.pg.paytm.response.head"(){
        setup:
        TransactionStatusRequest transactionStatusRequest = new TransactionStatusRequest()

        when:
        JSONObject dataHead = transactionStatusRequest.dataHead()

        then:
        null == dataHead
    }

    def "test TransactionStatusRequest data com.techsocialist.plugin.pg.paytm.response.body"(){
        setup:
        TransactionStatusRequest transactionStatusRequest = new TransactionStatusRequest()

        when:
        JSONObject dataBody = transactionStatusRequest.dataBody()

        then:
        null == dataBody
    }

    def "test TransactionStatusRequest data"(){
        setup:
        String orderId = String.format("ORDER-ID-%s", new Date().getTime())
        TransactionStatusRequest transactionStatusRequest = new TransactionStatusRequest()
        transactionStatusRequest.setMerchantId("mer-id-001")
        transactionStatusRequest.setMerchantKey("1111111111111111")
        transactionStatusRequest.setOrderId(orderId)

        when:
        JSONObject data = transactionStatusRequest.data()

        then:
        null != data && "{}" != data.toString()
    }

    def "test staging url end point prefix"(){
        setup:
        TransactionStatusRequest transactionStatusRequest = new TransactionStatusRequest()

        when:
        String stagingUrlEndPointPrefix = transactionStatusRequest.getStagingUrlEndPointPrefix()

        then:
        "https://securegw-stage.paytm.in/order/status" == stagingUrlEndPointPrefix
    }

    def "test production url end point prefix"(){
        setup:
        TransactionStatusRequest transactionStatusRequest = new TransactionStatusRequest()

        when:
        String productionUrlEndPointPrefix = transactionStatusRequest.getProductionUrlEndPointPrefix()

        then:
        "https://securegw.paytm.in/order/status" == productionUrlEndPointPrefix
    }

    def "test url"(){
        setup:
        TransactionStatusRequest transactionStatusRequest = new TransactionStatusRequest()

        when:
        String url = transactionStatusRequest.url(false)

        then:
        "https://securegw-stage.paytm.in/order/status" == url
    }

}
