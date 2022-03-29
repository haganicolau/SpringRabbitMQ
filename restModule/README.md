# Module REST

## Descrição do Módulo

Módulo que posssui o REST API, que expõem as operações:

- de soma
- de subtracção
- de multiplicação
- de divisão

### Sobre o Módulo

- Linguagem: Java JDK 11
- Framework: Spring Boot 2.6.4
- Logback: Logs

## Endpoints

### SUM Resource

| Parameter | Description |
| ------ | ------ |
| **Description Resource** |SUM Operation |
| **URI** | `/sum?a=3&b=2`
| **Methods** | `GET`|

#### Success

Code: `200`

```json
{
  "result": "5"
}
```

#### Fail

Code: `400`

```json
{
  "message": "Valores inválidos"
}
```

#### Curl

```bash
curl -X GET 'localhost:8081/sum?a=3&b=2'
```

### Subtraction Resource

| Parameter | Description |
| ------ | ------ |
| **Description Resource** |Subtraction Operation |
| **URI** | `/sub?a=3&b=2`
| **Methods** | `GET`|

#### Success

Code: `200`

```json
{
  "result": "1"
}
```

#### Fail

Code: `400`

```json
{
  "message": "Valores inválidos"
}
```

#### Curl

```bash
curl -X GET 'localhost:8081/sub?a=3&b=2'
```

### Multiplication Resource

| Parameter | Description |
| ------ | ------ |
| **Description Resource** |Multiplication Operation |
| **URI** | `/mult?a=3&b=2`
| **Methods** | `GET`|

#### Success

Code: `200`

```json
{
  "result": "6"
}
```

#### Fail

Code: `400`

```json
{
  "message": "Valores inválidos"
}
```

#### Curl

```bash
curl -X GET 'localhost:8081/mult?a=3&b=2'
```

### Division Resource

| Parameter | Description |
| ------ | ------ |
| **Description Resource** |Division Operation |
| **URI** | `/div?a=6&b=2`
| **Methods** | `GET`|

#### Success

Code: `200`

```json
{
  "result": "3"
}
```

#### Fail

Code: `400`

```json
{
  "message": "Valores inválidos"
}
```

Code: `400`

```json
{
  "message": "Impossível dividir por 0"
}
```

#### Curl

```bash
curl -X GET 'localhost:8081/div?a=6&b=2'
```

### Informações de LOG

- file: logs/access.log

```
"127.0.0.1" "2022-03-28 18:49:44" 65d2e3a4-5952-4d2e-8150-8b0488b8bd6a "GET /sum?a=3&b=2 HTTP/1.1" 200 "insomnia/2022.2.0"
"127.0.0.1" "2022-03-28 18:49:57" 9fdcf2c4-10a4-4384-858d-72a8bd5a0a0b "GET /sub?a=7&b=5 HTTP/1.1" 200 "insomnia/2022.2.0"
"127.0.0.1" "2022-03-28 18:50:00" 1874fbe9-e2f9-4892-9aa1-f1044eeaabd1 "GET /mult?a=9&b=9 HTTP/1.1" 200 "insomnia/2022.2.0"
"127.0.0.1" "2022-03-28 18:50:02" f92c6d69-19d4-42ba-ba55-db299930b77b "GET /div?a=8&b=2 HTTP/1.1" 200 "insomnia/2022.2.0"

```
