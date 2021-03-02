package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Service.GetAllProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getAllProductsController() throws Exception {
        try{
            return getAllProductsService.getAllProducts();
        }
        catch (Exception e) {
            throw new Exception("Error occurred during calling service of getting all products");
        }
        finally {
            System.out.println("Execution of GetAllProductsServiceControllerImpl is done");
        }

    }
}
