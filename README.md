desafio-associado-api
------------------------

API REST para consulta de associados

Requisitos
------------------------

- Docker
- Java 1.8 +
- Maven

Funcionalidades
------------------------

- Consultar associados

Demonstração
------------------------

<https://desafio-associado-api.herokuapp.com/swagger-ui/index.html>


Para construir a aplicação
------------------------

Execute os comandos abaixo:

	$ cd desafio-associado-api
	$ mvn clean install -DskipTests

Para executar a aplicação
------------------------

Execute os comandos abaixo:

	$ cd desafio-associado-api
	$ mvn spring-boot:run -Dspring-boot.run.profiles=dev

Documentação
------------------------

Swagger: <http://localhost:8080/swagger-ui/index.html>
