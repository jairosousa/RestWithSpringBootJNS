package br.com.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RestApiUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiUdemyApplication.class, args);
		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//		System.out.println("HASH: " + encoder.encode("jnsadmin"));
	}

}
