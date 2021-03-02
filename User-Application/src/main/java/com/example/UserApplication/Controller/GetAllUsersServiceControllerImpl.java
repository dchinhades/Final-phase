package com.example.UserApplication.Controller;

import com.example.UserApplication.Service.DeleteUserService;
import com.example.UserApplication.Service.GetAllUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GetAllUsersServiceControllerImpl {

    @Autowired
    private final GetAllUsersService getAllUsersService;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsersController() throws Exception {
        try{
            return getAllUsersService.getAllUsers();
        } catch (Exception e) {
            throw new Exception("Error occurred during calling service of getting all users");
        }
        finally {
            System.out.println("Execution of GetAllUsersServiceControllerImpl is done");
        }
    }
}

