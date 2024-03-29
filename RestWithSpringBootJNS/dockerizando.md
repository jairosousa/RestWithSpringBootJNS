# Dockerizando a Aplicação

## Dockerfile
* Cria-se arquivo criar a imagem da aplicação.
* Gerar jar aplicação:
```shell
$ mvn clean package -DskipTests=true
```

```
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

## Docker-composer

```yaml
version: '3.9'
services:
  db:
    image: mysql:latest
    command: mysqld --default-authentication-plugin=mysql_native_password
    restart: always
    environment:
      TZ: America/Sao_Paulo
      MYSQL_ROOT_PASSWORD: admin@123
      MYSQL_USER: docker
      MYSQL_PASSWORD: admin@123
      MYSQL_DATABASE: rest_with_spring_boot_db
      MYSQL_ROOT_HOST: '%'
      MYSQL_TCP_PORT: 3308
    ports:
      - 3308:3308
    expose:
      - 3308
    networks:
      - jnsdev-network
  rest-with-spring-boot-jns:
    image: jnsousa/rest-with-spring-boot-jns
    restart: always
    build: .
    working_dir: /rest-with-spring-boot-and-java-jns
    environment:
      TZ: America/Sao_Paulo
      SPRING.DATASOURCE.URL: jdbc:mysql://db:3308/rest_with_spring_boot_db?useTimezone=true&serverTimezone=UTC
      SPRING.DATASOURCE.USERNAME: root
      SPRING.DATASOURCE.PASSWORD: admin@123
    ports:
      - 80:80
    command: mvn spring-boot:run
    depends_on:
      - db
    networks:
      - jnsdev-network
networks:
  jnsdev-network:
    driver: bridge
```

### Gerar imagem e subir a aplicação
```shell
$ docker compose up -d --build
```

### Listar comtainers com docker compose
```shell
$ docker compose ls
```

### Listar e acompanhar logs container
```shell
$ docker logs <id container> -f
```

## Enviar Docker image para Dockerhub

```shell
$ docker login
```

```shell
$ docker push usuario/nome_imagem
```


# Referências
* [Spring Boot Docker](https://spring.io/guides/topicals/spring-boot-docker/)