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

Servicio para calcular la conversión de moneda:

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
