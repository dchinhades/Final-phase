package com.example.UserApplication.Controller;

import com.example.UserApplication.Service.DeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteUserServiceControllerImpl {

    @Autowired
    private final DeleteUserService deleteUserService;

    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUserController(@PathVariable int userId) throws Exception {
        try{
            return deleteUserService.deleteUser(userId);
        } catch (Exception e) {
            throw new Exception("Error occurred during calling service of deleting an user");
        }
        finally {
            System.out.println("Execution of DeleteUserServiceControllerImpl is done");
        }
    }
}
