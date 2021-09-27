# Mutants

Proyecto que permite identificar un mutante de acuerdo a su secuencia de ADN

Implementado en java 

###### Arquitectura
A continuación se describe la arquitectura y como interactuan sus componentes.

![alt tag](https://meli.blob.core.windows.net/images/mutantes.png)

Base de datos MongoDb
mongodb+srv://magneto:FrgDLPh2AKRRiz7@cluster0.uh4f8.mongodb.net/meli?retryWrites=true&w=majority

## Descripción
Servicio que permite a través de una secuecia de ADN determinar si un humano es mutante


Ejemplos:

###### No mutante
```
["ATGCGA","CAGTGC","TTATTT","AGACGG","AGACGG","TCACTG"]
```
###### Mutante
```
["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
```
## Generación de token

Se utiliza keycloak para la autenticación con el servicio backend

A través de la siguiente url puede generar el token para el consumo la api

[http://server-backend1.eastus.cloudapp.azure.com:8080/auth/realms/meli/protocol/openid-connect/token](http://server-backend1.eastus.cloudapp.azure.com:8080/auth/realms/meli/protocol/openid-connect/token)

Se genera un client y un secret con el cual se genera un token que permite el uso de la api.

POST
```
'Content-Type: application/x-www-form-urlencoded'
'grant_type=client_credentials'
'client_id=meli-mutant'
'client_secret=3568f96e-bff0-4033-b918-5fbdb40fe637'
```

Ejemplo a través de postman

![alt tag](https://meli.blob.core.windows.net/images/get%20token.png)

## La url de consumo

http://www.melimutantstest.tk/

## Para analizar la secuencia de adn

POST 

http://www.melimutantstest.tk/mutant/

header Authorization bearer  {{tokenMutant}}

```
Body
{
  "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```

## Para las estadisticas

GET
http://www.melimutantstest.tk/stats

header Authorization bearer  {{tokenMutant}}

```
Response
{
    "ratio": 0.6666666666666666,
    "count_mutant_dna": 2,
    "count_human_dna": 3
}
```

## Swagger
http://www.melimutantstest.tk/swagger-ui.html

Listado de operaciones

![alt tag](https://meli.blob.core.windows.net/images/swagger1.png)

![alt tag](https://meli.blob.core.windows.net/images/swagger2.png)

![alt tag](https://meli.blob.core.windows.net/images/swagger3.png)

Autorización

![alt tag](https://meli.blob.core.windows.net/images/swagger oauth.png)

## Postman para probar:
Puede descargar la coleccion de postman con los metodos 

https://meli.blob.core.windows.net/postman/Meli%20mutants.postman_collection.json




