# Projeto Principal Spring RabbitMQ

## Descrição do Projeto

Este é um projeto que tem como objetivo fornecer uma API para efetuar operações matemáticas.

Requisitos Funcionais:

- REST API que expõe as operações de soma, subtracção, multiplicação e divisão.
- Suporte para dois operandos apenas (a e b).

Requisitos Não Funcionais:

- Maven
- Resiliência, integração entre os módulos fazendo uso do RabbitMQ
- Escalável, ambiente docker, permitindo escala horizontal

### Módulos

- Rest Module: [Clique aqui!](restModule/README.md)
- Engine Module: [Clique aqui!](engineModule/README.md)
- Lib DTO Data: [Clique aqui!](libDataDtoChangelle/README.md)

obs. Clique em cada um dos módulos para descrição e detalhe de cada um.

### Sobre o projeto

- Linguagem: Java JDK 11
- Framework: Spring Boot 2.6.4
- Build usando Docker e Docker-Compose

## Preparar ambiente de desenvolvimento

1. Clonando projeto

    - No terminal:

```bash
    git clone git@github.com:haganicolau/SpringRabbitMQ.git
```

2. Buildando e executando projeto

    - No terminal:

```bash
    docker-compose up --build
```

3. Testando a aplicação
    - Acessse o arquivo do Insomnia que se encontra no diretório: doc/insomnia/Insomnia.json. Importe e execute os
      testes.

## Acesso a Logs

Ao executar o projeto a partir da imagem docker é criado uma pasta de logs, sendo para cada projeto:

- .SpringRabbitMQ/logs/engineModule: Logs do módulo engineModule
- .SpringRabbitMQ/logs/restModule: Logs do módulo restModule

Ao ser executado fora do container em uma IDE (por exemplo), os projetos podem ser executados separados, portanto é
criado uma pasta /logs é para cada projeto.

- .SpringRabbitMQ/engineModule/logs: Logs do módulo engineModule
- .SpringRabbitMQ/restModule/logs: Logs do módulo restModule

## Docs

### Arquivo Insomna

- Para acessar: [Clique aqui!](doc/insomnia/Insomnia.json)

obs.: Importe o aquivo do insomina, para fazer os testes de API.

### Diagrama de Implantação

<img src="https://github.com/haganicolau/SpringRabbitmq/blob/main/doc/diagrams/modules.png" width="550">

### Diagrama de Sequencia Rest Modulo

<img src="https://github.com/haganicolau/SpringRabbitmq/blob/main/doc/diagrams/senquence-rest-modulo.png" width="550">

### Diagrama de Sequencia Engine Modulo

<img src="https://github.com/haganicolau/SpringRabbitmq/blob/main/doc/diagrams/sequence-engine-module.png" width="550">


### Diagrama de Sequencia Compute Vote Modulo

<img src="https://github.com/haganicolau/SpringRabbitmq/blob/main/doc/diagrams/sequence-compute-vote.png" width="550">
