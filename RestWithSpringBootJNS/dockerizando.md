# Dockerizando a Aplicação

## Dockerfile
* Cria-se arquivo criar a imagem da aplicação.
* Gerar jar aplicação:
```shell
$ mvn clean package -DskipTests=true
```

```
FROM eclipse-temurin:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```



# Referências
* [Spring Boot Docker](https://spring.io/guides/topicals/spring-boot-docker/)