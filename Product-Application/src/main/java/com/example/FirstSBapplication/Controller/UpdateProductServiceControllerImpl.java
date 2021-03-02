package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Service.GetProductByIdService;
import com.example.FirstSBapplication.Service.UpdateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UpdateProductServiceControllerImpl{

    @Autowired
    private final UpdateProductService updateProductService;

    @RequestMapping(path = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProductController(@RequestBody Product product, @PathVariable int id) throws Exception {
        try {
            return updateProductService.updateProduct(product,id);

        } catch (Exception e) {
            throw new Exception("Error occurred during calling service of updating a product");
        }
        finally {
            System.out.println("Execution of UpdateProductServiceControllerImpl is done");
        }
    }
}
