package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Service.DeleteProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteProductServiceControllerImpl{

    @Autowired
    private final DeleteProductService deleteProductService;

    @RequestMapping(path = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProductController(@PathVariable int id) throws Exception {
        try {
            return deleteProductService.deleteProduct(id);

        } catch (Exception e) {
            throw new Exception("Error occurred during calling service of creating a new product");
        }
        finally {
            System.out.println("Execution of CreateProductServiceControllerImpl is done");
        }
    }
}
