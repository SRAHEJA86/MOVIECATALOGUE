package com.magellan;

import com.magellan.service.CatalogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogApplication.class, args);
	}

	@Bean
	public CatalogService getCatalogService(){
		return new CatalogService();
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}