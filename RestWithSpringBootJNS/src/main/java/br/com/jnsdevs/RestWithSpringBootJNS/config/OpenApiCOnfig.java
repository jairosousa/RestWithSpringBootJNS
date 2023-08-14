package br.com.jnsdevs.RestWithSpringBootJNS.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Autor Jairo Nascimento
 * @Created 14/08/2023 - 15:32
 */
@Configuration
public class OpenApiCOnfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful API with Java 17 and Spring Boot 3")
                        .version("v1")
                        .description("Some description about your API")
                        .termsOfService("https://jairosousa.github.io/")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://jairosousa.github.io/")
                        )
                );
    }

}
