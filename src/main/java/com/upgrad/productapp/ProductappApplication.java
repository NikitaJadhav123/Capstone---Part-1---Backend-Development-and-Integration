package com.upgrad.productapp;

import com.upgrad.productapp.services.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Bean
	CommandLineRunner init (InitService initService){
		return args -> {
			initService.init();
		};
	}

}
