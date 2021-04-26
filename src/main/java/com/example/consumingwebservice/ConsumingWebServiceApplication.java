package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.ResponseNotification;
import com.example.consumingwebservice.wsdl.ResponsePayment;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsumingWebServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner lookup(PaymentClient quoteClient) {
    return args -> {
      int id = 67;
      long transactionId = 100;

      UUID uuid = UUID.randomUUID();
      String paymentId = uuid.toString();

      String type = "1";

      if (args.length > 0) {
        type = args[0];
        id = Integer.parseInt(args[1]);
        transactionId = Long.parseLong(args[2]);
      }
      if (type.equals("1")) {
        ResponsePayment response = quoteClient.getPayment(id);
      } else {
        ResponseNotification res = quoteClient.sendNotification(
          transactionId,
          id,
          paymentId
        );
      }
      // System.err.println(response.getClient().getName());
    };
  }
}
