package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Service.GetAllProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetAllProductsServiceControllerImpl{

    @Autowired
    private final GetAllProductsService getAllProductsService;

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProductsController() {
        return getAllProductsService.getAllProducts();
    }
}
