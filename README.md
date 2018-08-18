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

## Diseño propuesto
![alt text](https://github.com/kathe20m/retail/blob/master/modelo%20retail/RETAIL_DESIGN.jpg)
