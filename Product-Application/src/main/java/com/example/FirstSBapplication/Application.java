package com.example.FirstSBapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
//@EnableConfigServer
@ComponentScan({"com.example.FirstSBapplication"})
public class Application {

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
		SpringApplication.run(Application.class, args);
	}

}
