package com.example.UserApplication.Service;

import com.example.UserApplication.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class UserProductsService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public ResponseEntity<Object[]> getUserProducts(int userId) throws Exception {
        try{
            Object user = userRepository.findById(userId);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            Object[] userProducts=restTemplate.getForObject("http://localhost:8080/products",Object[].class);
            return ResponseEntity.ok().headers(httpHeaders).body(userProducts);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during execution of UserProductsService");
        }
        finally {
            System.out.println("Execution of UserProductsService is done");
        }
    }



}
