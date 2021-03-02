package com.example.FirstSBapplication.Controller;

import com.example.FirstSBapplication.Service.DeleteProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void deleteProductController(@PathVariable int id) {
        deleteProductService.deleteProduct(id);
    }
}
