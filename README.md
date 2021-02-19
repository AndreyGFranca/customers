# Customer Manager

[![Automated Testing](https://github.com/AndreyGFranca/customers/actions/workflows/maven.yml/badge.svg)](https://github.com/AndreyGFranca/customers/actions/workflows/maven.yml)

Projeto backend com java e spring boot.

### Arquitetura
Com uma implementação de [Clean Arch](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

A qualidade dos testes é validada pelo JaCoCo

CI da aplicação é o Actions do github

### Build
Para construir a aplicação e rodar toda a suite de testes maven.
```
mvn clean install

java -jar ./target/customer-manager-0.0.1-SNAPSHOT.jar
```

### Utilizando a aplicação
A Utilização da API pode ser feita através de seu Swagger http://localhost:8080/swagger-ui.html

Health Check: http://localhost:8080/actuator/health
