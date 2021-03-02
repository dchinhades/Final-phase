package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Service.GetProductByIdService;
import com.example.FirstSBapplication.Service.UpdateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UpdateProductServiceControllerImpl{

    @Autowired
    private final UpdateProductService updateProductService;

    @RequestMapping(path = "/products/{id}", method = RequestMethod.PUT)
    public void updateProductController(@RequestBody Product product, @PathVariable int id) {
        updateProductService.updateProduct(product,id);
    }
}
