<h1 align="center">
Currency Exchange Challenge
</h1>

<h4 align="center">Backend Developer Reto Tech.</h4>
<h4 align="center">Claudio Alfredo Palomino Yangua.</h4>

<p align="center">
    <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v11-blue.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v2.5.2-brightgreen.svg" />
    </a>
    <a alt="H2">
        <img src="https://img.shields.io/badge/H2-v1.4.200-brightgreen.svg" />
    </a>
    <a alt="JPA">
        <img src="https://img.shields.io/badge/JPA-v2.4.3-brightgreen.svg" />
    </a>

</p>

## Aplicación

Servicio para calcular la conversión de moneda

- Antes de realizar una petición a los servicios se debera realizar la autenticación y autorización
  del usuario mediante la generación de una llave JWT:

```shell
curl --location --request POST 'http://localhost:9092/oauth/token' \
--header 'Authorization: Basic dGVzdGp3dGNsaWVudGlkOlhZN2ttem9OemwxMDA=' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=admin.admin' \
--data-urlencode 'password=challenge-jwt'
```

- Donde la respuesta del servicio tiene el siguiente formato:

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNjI4NDUwNTk5LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiI2M2Q0MTQwOC0zOWM1LTRiNGItOTE5Yi0xZGRhZGI5NTY2YzUiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.jG0aPGBhFyman2aW1oltIfNBvFRqvBJzSrj2NHIYTp8",
  "token_type": "bearer",
  "expires_in": 3599999,
  "scope": "read write",
  "jti": "63d41408-39c5-4b4b-919b-1ddadb9566c5"
}

```

- Para el consumo de los servicios se deberá colocar como header el valor de access_token en "
  Authorization":

```shell
curl --location --request GET 'http://localhost:9092/service/v1/exchange-rate/all' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4uYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNjI4NDUwNTk5LCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIiwiQURNSU5fVVNFUiJdLCJqdGkiOiI2M2Q0MTQwOC0zOWM1LTRiNGItOTE5Yi0xZGRhZGI5NTY2YzUiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.jG0aPGBhFyman2aW1oltIfNBvFRqvBJzSrj2NHIYTp8'
```

### 1. Consultar Tipo de cambio por moneda y monto

#### cURL Request

```shell

curl --location --request GET 'http://localhost:9092/service/v1/exchange-rate/converter?source=USD&target=PEN&amount=140'
```

### 2. Consultar todos los tipos de cambios

#### cURL Request

```shell
curl --location --request GET 'http://localhost:9092/service/v1/exchange-rate/all'
```

### 3. Consultar Monedas

#### cURL Request

```shell
curl --location --request GET 'http://localhost:9092/service/v1/currency/all'
```

### 4. Registrar Tipo de cambio

#### cURL Request

```shell
curl --location --request POST 'http://localhost:9092/service/v1/exchange-rate/registry' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sourceId": 1,
    "targetId": 3,
    "rate": 3.5
}'
```

### 5. Registrar Moneda

#### cURL Request

```shell
curl --location --request POST 'http://localhost:9092/service/v1/currency/registry' \
--header 'Content-Type: application/json' \
--data-raw '{
    "code": "EUR",
    "description": "Euro" 
}'
```

### 6. Actualizar Tipo de cambio

#### cURL Request

```shell
curl --location --request PUT 'http://localhost:9092/service/v1/exchange-rate/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sourceId": 1,
    "targetId": 2,
    "rate": 3.97
}'
```

## Ejecutar en Docker Container ##

##### Docker ##### 

Comando para compilar el contenedor:

```shell
docker build -t "spring-currency-exchange-docker" .
```

Comando para ejecutar el contenedor:

```shell
docker run --name spring-currency-exchange-docker -p 9092:9092 spring-currency-exchange-docker:latest
```
