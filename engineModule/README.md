# Module Engine

## Descrição do Projeto

Motor que retira do Broker RabbitMQ os operandos e efetua os cáculos. Após concluir as operações volta o resultado para
o broker para ser processado pelo módulo Rest.

### Sobre o Módulo

- Linguagem: Java JDK 11
- Framework: Spring Boot 2.6.4
- Logback: Logs

## Sobre Testes unitários

Foram criados alguns testes unitários apenas a título de apresentação das operações matemáticas.

No terminal:

```bash
    mvn test
```

### Logs

- file: rabbit.log

```
"2022-03-28 19:00:11" "OperatorsDTO {requestId= cb37f582-49e4-40eb-aab8-5c804c7e352c, first=3, second=2, operationType='SUM'}" 
"2022-03-28 19:00:13" "OperatorsDTO {requestId= ddd9d792-f5af-497f-bcaf-73645eb97164, first=7, second=5, operationType='SUBTRACTION'}" 
"2022-03-28 19:00:15" "OperatorsDTO {requestId= 456912ff-24e3-4046-ae87-102aa0e2a57e, first=9, second=9, operationType='MULTIPLICATION'}" 
"2022-03-28 19:00:17" "OperatorsDTO {requestId= e24e2d3c-b1be-4cc7-a280-03940219e14a, first=8, second=2, operationType='DIVISION'}" 

```

