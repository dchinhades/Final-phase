package com.example.FirstSBapplication.Service;


import com.example.FirstSBapplication.Repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Data
public class GetProductByIdService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public ResponseEntity<Object> getProductById(int id) throws Exception {
        try{
            Object product = productRepository.findById(id);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            return ResponseEntity.ok().headers(httpHeaders).body(product);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during execution of GetProductByIdService");
        }
        finally {
            System.out.println("Execution of GetProductByIdService is done");
        }
    }
}
