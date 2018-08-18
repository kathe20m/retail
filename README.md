# Caso Reatil

## Integrantes
- Laura Katherine Salazar Higuita
- Luis Fernando Moreno Oviedo
- Katherine Mancera Arango

## Overview  
Proyecto que contiene 2 modulos:
### batch-process: 
Este módulo se encarga de simular el proceso batch que sirve de entrada de información para Retail. Expone 3 operaciones:
* /batchprocess/client/send: Envia la información del cliente al exchange "exchange_retail" mediante el routing_key "cliente".
* /batchprocess/sale/send: Envia la información de una venta al exchange "exchange_retail" mediante el routing_key "venta".
* /batchprocess/refund/send: Envia la información de una devolución al exchange "exchange_retail" mediante el routing_key "devolucion".

### client-api:
Esta API se encarga de obtener la información del cliente de la cola "cliente_procesado", la guarda en una base de datos simulada y luego mediante la operación /client/getclient  se obtiene un cliente especifico al pasarle como parametro el clientIdentification.

## Data
La información necesaria para probar los módulos mencionados está en la carpeta RETAIL_COLLECTION donde se encuentra la colección de postman con las operaciones y los datos.

## Proposed design
![alt text](https://github.com/kathe20m/retail/blob/master/modelo%20retail/RETAIL_DESIGN.jpg)

### Explanation design
En el anterior diagrama se refactorizó más que todo el retail como tal, se mantuvo el proceso batch en el ingreso de la información y lo simulamos con un servicio pequeño encargado de enviar a las colas los datos de las ventas, devoluciones y clientes. Este batch-process se conecta al exchange "exchange-retail", configurado como topic, este tiene conexión a 3 colas: cliente_procesado (routing_key "cliente"), venta_procesada (routing_key "venta") y devolucion_procesada (routing_key "devolucion"). A parte, entran en juego 3 microservicios, client-api, venta-api y devolucion-api, encargados de procesar la información y guardarla en la base de datos de cada uno. Para nuestro caso solo se implementó cliente-api para mostrar el funcionamiento de un consumidor y se expuso la operación para consultar un cliente mediante su id. Para finalizar, están los servidores CRM, CARTERA y PROVEEDOR que son los encargados de consumir los microservicios anteriores.
