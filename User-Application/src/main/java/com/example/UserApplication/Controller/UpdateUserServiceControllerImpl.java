package com.example.UserApplication.Controller;

import com.example.UserApplication.Entity.User;
import com.example.UserApplication.Service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UpdateUserServiceControllerImpl{

    @Autowired
    private final UpdateUserService updateUserService;

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProductController(@RequestBody User user, @PathVariable int userId) throws Exception {
        try {
            return updateUserService.updateUser(user,userId);
        } catch (Exception e) {
            throw new Exception("Error occurred during calling service of updating an user");
        }
        finally {
            System.out.println("Execution of UpdateUserServiceControllerImpl is done");
        }
    }
}