package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetPaymentRequest;
import com.example.consumingwebservice.wsdl.PaymentNotification;
import com.example.consumingwebservice.wsdl.ResponseNotification;
import com.example.consumingwebservice.wsdl.ResponsePayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PaymentClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(
    PaymentClient.class
  );
  String URL = "https://pedidossanos.cajavecina.test-citiaps.cl/ws";

  public ResponsePayment getPayment(int orderId) {
    GetPaymentRequest request = new GetPaymentRequest();
    request.setOrderId(orderId);
    ResponsePayment response = (ResponsePayment) getWebServiceTemplate()
      .marshalSendAndReceive(
        URL,
        request,
        new SoapActionCallback(
          "http://pedidossanos.cl/web-service/getPaymentRequest"
        )
      );
    return response;
  }

  public ResponseNotification sendNotification(
    long transactionId,
    long orderId,
    String paymentId
  ) {
    PaymentNotification request = new PaymentNotification();

    request.setTransactionId(transactionId);
    request.setOrderId(orderId);
    request.setPaymentId(paymentId);

    ResponseNotification response = (ResponseNotification) getWebServiceTemplate()
      .marshalSendAndReceive(
        URL,
        request,
        new SoapActionCallback(
          "http://pedidossanos.cl/web-service/paymentNotification"
        )
      );

    return response;
  }
}
