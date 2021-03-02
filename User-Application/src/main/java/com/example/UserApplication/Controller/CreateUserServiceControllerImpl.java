package com.example.UserApplication.Controller;

import com.example.UserApplication.Entity.User;
import com.example.UserApplication.Service.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateUserServiceControllerImpl {

    @Autowired
    private final CreateUserService createUserService;

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> createUserController(@RequestBody User user) throws Exception {
        try {
            return createUserService.createUser(user);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during calling service of creating a new user");
        }
        finally {
            System.out.println("Execution of CreateUserServiceControllerImpl is done");
        }

    }

}
