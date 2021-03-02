package com.example.UserApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication {

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
		SpringApplication.run(UserApplication.class, args);
	}

}
