package com.example.UserApplication.Service;

import com.example.UserApplication.Entity.User;
import com.example.UserApplication.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
@Data
public class CreateUserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public ResponseEntity<String> createUser(User user) throws Exception {
        try{
            String message = "Created user " + user.getUserName() + " successfully";
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            userRepository.save(user);
            return new ResponseEntity<>(message,httpHeaders, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during execution of CreateUserService");
        }
        finally {
            System.out.println("Execution of CreateUserService is done");
        }
    }

}
