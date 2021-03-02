package com.example.FirstSBapplication.Service;


import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class GetProductByIdService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public Optional<Product> getProductById(int id) {
//        logger.debug("Getting a product by id "+id);
        return productRepository.findById(id);
    }
}
