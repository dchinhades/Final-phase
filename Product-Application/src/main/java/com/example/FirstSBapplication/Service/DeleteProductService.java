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
public class DeleteProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public ResponseEntity<String> deleteProduct(int id) throws Exception {
        try{
            String message = "Product " + productRepository.findById(id).get().getName() + " deleted successfully";
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            productRepository.deleteById(id);
            return new ResponseEntity<String>(message,httpHeaders, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during deletion of a product " + productRepository.findById(id).get().getName());
        }
        finally {
            System.out.println("Product " + productRepository.findById(id).get().getName() + " deleted successfully");
        }
    }
}
