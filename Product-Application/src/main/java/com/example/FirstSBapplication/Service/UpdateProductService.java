package com.example.FirstSBapplication.Service;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Data
public class UpdateProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public void updateProduct(Product product, int id) {
//        logger.debug("Updating a product " + product + " with id " + id);
        productRepository.save(product);
    }
}
