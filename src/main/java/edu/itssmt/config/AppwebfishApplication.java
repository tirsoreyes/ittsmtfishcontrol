package edu.itssmt.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="edu.itssmt")
@EnableAutoConfiguration
public class AppwebfishApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppwebfishApplication.class, args);
	}
}
