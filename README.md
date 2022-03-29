# Projeto Principal Spring RabbitMQ

## Descrição do Projeto
Este projeto foi criado com objetivo de definir uma plataforma escalável e performática, foram criados dois módulos e uma 
lib interagindo com o RabbitMQ. 

### Sobre o projeto

- Linguagem: Java JDK 11
- Framework: Spring Boot 2.6.4
- Build usando Docker e Docker-Compose

## Módulos

- Rest Module: [Clique aqui!](restModule/README.md)
- Engine Module: [Clique aqui!](engineModule/README.md)
- Lib DTO Data: [Clique aqui!](libDataDtoChangelle/README.md)

obs. Clique em cada um dos módulos para descrição e detalhe de cada um.

## Preparar ambiente de desenvolvimento

1. Clonando projeto

   - No terminal:

```bash
    git clone git@github.com:haganicolau/spring-rabb
```

2. Buildando e executando projeto

   - No terminal:

```bash
    docker-compose up --build
```

3. Testando a aplicação
   - Acessse o arquivo do Insomnia que se encontra no diretório: doc/insomnia/Insomnia.json. Importe e execute os testes.

## Acesso a Logs
Ao executar o projeto a partir da imagem docker é criado uma pasta de logs, sendo para cada projeto:
- ./logs/engineModule: Logs do módulo engineModule
- ./logs/restModule: Logs do módulo restModule

Ao ser executado fora do container em uma IDE (por exemplo), a pasta /logs é criada dentro de cada projeto.

## Doc
### Arquivo Insomna
- Para acessar: [Clique aqui!](doc/insomnia/Insomnia.json)

obs.: Importe o aquivo do insomina, para fazer os testes de API.

### Diagrama de Implantação
<img src="https://github.com/haganicolau/SpringRabbitmq/blob/main/doc/diagrams/modules.png" width="550">


### Diagrama de Sequencia Rest Modulo
<img src="https://github.com/haganicolau/spring-rabbitmq/blob/main/doc/diagrams/senquence-rest-modulo.png" width="550">

### Diagrama de Sequencia Engine Modulo
<img src="https://github.com/haganicolau/spring-rabbitmq/blob/main/doc/diagrams/sequence-engine-module.png" width="550">
