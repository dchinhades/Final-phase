package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Entity.Product;
import com.example.FirstSBapplication.Repository.ProductRepository;
import com.example.FirstSBapplication.Service.GetProductByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GetProductByIdServiceControllerImpl{

    @Autowired
    private final GetProductByIdService getProductByIdService;

    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProductByIdController(@PathVariable("id") int id) throws Exception {
        try{
            return getProductByIdService.getProductById(id);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during calling service of getting a product");
        }
        finally {
            System.out.println("Execution of GetProductByIdServiceControllerImpl is done");
        }

    }
}
