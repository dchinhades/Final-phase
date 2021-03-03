package com.example.FirstSBapplication.Repository;

import com.example.FirstSBapplication.Entity.Product;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
