package br.com.jnsdevs.RestWithSpringBootJNS.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Autor Jairo Nascimento
 * @Created 13/08/2023 - 18:27
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        /**
         * Implemantação Via QUERY PARAM
         * /api/person/v1?mediaType=xml
         * @param configurer
         */
//        configurer.favorParameter(true)
//        .parameterName("mediaType")
//        .ignoreAcceptHeader(true)
//        .useRegisteredExtensionsOnly(false)
//        .defaultContentType(MediaType.APPLICATION_JSON)
//        .mediaType("json", MediaType.APPLICATION_JSON)
//        .mediaType("xml", MediaType.APPLICATION_XML);

        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);

    }
}
