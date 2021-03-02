package com.example.FirstSBapplication.Service;

import com.example.FirstSBapplication.Repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Data
public class DeleteProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public void deleteProduct(int id) {
//        logger.debug("Deleting a product with id "+id);
        productRepository.deleteById(id);
    }
}
