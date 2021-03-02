package com.example.FirstSBapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@ComponentScan({"com.example.FirstSBapplication"})
@EnableEurekaClient
public class ProductApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public HttpHeaders httpHeaders() {
		return new HttpHeaders();
	}
	@Bean
	public URI baseUri() throws URISyntaxException {
		return new URI("http://localhost:8080/products");
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
