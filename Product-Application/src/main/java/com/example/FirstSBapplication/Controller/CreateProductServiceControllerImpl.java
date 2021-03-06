package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Service.CreateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateProductServiceControllerImpl {

    @Autowired
    private final CreateProductService createProductService;

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public ResponseEntity<String> createProductController(@RequestBody Product product) throws Exception {
        try {
            return createProductService.createProduct(product);

        } catch (Exception e) {
            throw new Exception("Error occurred during calling service of creating a new product");
        }
        finally {
            System.out.println("Execution of CreateProductServiceControllerImpl is done");
        }
    }
}
