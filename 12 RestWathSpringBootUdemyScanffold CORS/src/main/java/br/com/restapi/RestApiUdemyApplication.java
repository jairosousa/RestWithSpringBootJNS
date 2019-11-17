package br.com.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RestApiUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiUdemyApplication.class, args);
	}

}
