package com.example.FirstSBapplication.Service;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class GetAllProductsService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    private final URI baseUri;

    public ResponseEntity<Object> getAllProducts() throws Exception {
        try{
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            List<Product> products = new ArrayList<>();
            productRepository.findAll().forEach(products::add);
            return ResponseEntity.ok().headers(httpHeaders).body(products);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during execution of GetAllProductsService");
        }
        finally {
            System.out.println("Execution of GetAllProductsService is done");
        }
    }
}
