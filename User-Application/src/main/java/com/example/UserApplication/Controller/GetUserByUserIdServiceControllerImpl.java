package com.example.UserApplication.Controller;

import com.example.UserApplication.Service.GetAllUsersService;
import com.example.UserApplication.Service.GetUserByUserIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GetUserByUserIdServiceControllerImpl {

    @Autowired
    private final GetUserByUserIdService getUserByUserIdService;

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsersController(@PathVariable int userId) throws Exception {
        try{
            return getUserByUserIdService.getUserByUserId(userId);
        } catch (Exception e) {
            throw new Exception("Error occurred during calling service of getting an user");
        }
        finally {
            System.out.println("Execution of GetUserByUserIdServiceControllerImpl is done");
        }
    }
}