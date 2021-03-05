package com.example.UserApplication.Controller;

import com.example.UserApplication.Entity.User;
import com.example.UserApplication.Service.UserProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserProductsServiceControllerImpl {

    @Autowired
    private final UserProductsService userProductsService;

    @RequestMapping(path = "/users/{userId}/products",method = RequestMethod.GET)
    public ResponseEntity<User> userProductsController(@PathVariable int userId) throws Exception {
        try {
            return userProductsService.getUserProducts(userId);
        } catch (Exception e) {
            throw new Exception("Error occurred during calling service of getting products of an user");
        }
        finally {
            System.out.println("Execution of UserProductsServiceControllerImpl is done");
        }
    }

}
