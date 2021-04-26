# Código de ejemplo para consultar servicio SOAP de pedidos sanos

Este código se realizó siguiendo esta guia :

https://spring.io/guides/gs/consuming-web-service/

Instrucciones para ejecutar

* Para compilar se debe ejecutar el siguiente comando ( se requiere tener instalado gradle):

```
gradle build
```

* Para consultar una deuda se debe llamar a la siguiente instrucción:

```
java -jar build/libs/gs-consuming-web-service-0.0.1.jar 1  idOrder 0
```

* Donde "idOrder" representa la id de el número de orden a consultar ( los demás parámetros se deben mantener constantes).

* Para pagar una deuda se debe llamar a la siguiente instrucción:

```
java -jar build/libs/gs-consuming-web-service-0.0.1.jar 2  idOrder idTransacción
```

* Donde "idOrder" representa el número del número de orden a pagar e "idTransaccion" representa el número de transacción del pago ( retornado al consultar la deuda).
