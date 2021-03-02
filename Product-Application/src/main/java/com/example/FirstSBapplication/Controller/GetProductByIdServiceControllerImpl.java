package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Repository.ProductRepository;
import com.example.FirstSBapplication.Service.GetProductByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GetProductByIdServiceControllerImpl{

    @Autowired
    private final GetProductByIdService getProductByIdService;

    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public Optional<Product> getProductByIdController(@PathVariable("id") int id) {
        return getProductByIdService.getProductById(id);
    }
}
