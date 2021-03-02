package com.example.FirstSBapplication.Service;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Data
public class UpdateProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public ResponseEntity<String> updateProduct(Product product, int id) throws Exception {
        try{
            String message = "Product " + product.getName() + " updated successfully";
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            productRepository.save(product);
            return new ResponseEntity<>(message,httpHeaders, HttpStatus.OK);
        }
        catch(Exception e) {
            throw new Exception("Error occurred during updating of a product" + product.getName());
        }
        finally {
            System.out.println("Product " + product.getName() + " updated successfully");
        }
    }
}
