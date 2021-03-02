package com.example.UserApplication.Service;

import com.example.UserApplication.Entity.User;
import com.example.UserApplication.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class GetAllUsersService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public ResponseEntity<Object> getAllUsers() throws Exception {
        try{
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            List<User> users = new ArrayList<>();
            userRepository.findAll().forEach(users::add);
            return ResponseEntity.ok().headers(httpHeaders).body(users);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during execution of GetAllUsersService");
        }
        finally {
            System.out.println("Execution of GetAllUsersService is done");
        }
    }
}
