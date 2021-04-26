package com.example.consumingwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
public class PaymentConfiguration {

  @Bean
  public Wss4jSecurityInterceptor securityInterceptor() {
    Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
    wss4jSecurityInterceptor.setSecurementActions("Timestamp UsernameToken");
    wss4jSecurityInterceptor.setSecurementUsername("CajaVecinaTest");
    wss4jSecurityInterceptor.setSecurementPassword("3Kp3by2haz");
    return wss4jSecurityInterceptor;
  }

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.example.consumingwebservice.wsdl");
    return marshaller;
  }

  @Bean
  public PaymentClient countryClient(Jaxb2Marshaller marshaller) {
    PaymentClient client = new PaymentClient();
    client.setDefaultUri("https://pedidossanos.cajavecina.test-citiaps.cl/ws");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    ClientInterceptor[] interceptors = new ClientInterceptor[] {
      securityInterceptor(),
    };
    client.setInterceptors(interceptors);
    return client;
  }
}
