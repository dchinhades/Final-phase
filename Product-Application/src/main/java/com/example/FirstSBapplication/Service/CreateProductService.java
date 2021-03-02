package com.example.FirstSBapplication.Service;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Data
public class CreateProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public ResponseEntity<Product> createProduct(Product product) throws Exception {
        try{
            URI uri = new URI("http://localhost:8080/products");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-type","application/json");
            String message = "Created a product successfully";
            HttpEntity<Product> httpEntity = new HttpEntity<Product>(product,httpHeaders);
            ResponseEntity<Product> responseData = restTemplate.exchange(uri,HttpMethod.POST,httpEntity,Product.class);
            return responseData;


//            HttpHeaders httpHeaders = new HttpHeaders();
//            httpHeaders.set("Content-Type","application/json");
//            HttpEntity<?> httpEntity = new HttpEntity(httpHeaders);
//            ResponseEntity<Object> responseData = restTemplate.exchange("http://localhost:8080", HttpMethod.POST,httpEntity,Product.class);
//            productRepository.save(product);
//            responseInfo.setMessage("Product created successfully");
//            responseInfo.setData(product);
//            return new ResponseEntity<>(responseInfo, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception("Error occured during creation of an object");
        }
        finally {
            // logger.info("Method executed");
        }
    }
}
