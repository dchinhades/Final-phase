package com.example.FirstSBapplication.Service;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class GetAllProductsService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public List<Product> getAllProducts() {
//        logger.error("Getting all products ");
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }
}
