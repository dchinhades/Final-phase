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

@Service
@RequiredArgsConstructor
@Data
public class UpdateUserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    public ResponseEntity<String> updateUser(User user, int userId) throws Exception {
        try {
            String message = "User " + userRepository.findById(userId).get().getUserName() + " updated successfully";
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            userRepository.save(user);
            return new ResponseEntity<>(message,httpHeaders, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during execution of UpdateUserService");
        }
        finally {
            System.out.println("Execution of UpdateUserService is done");
        }
    }
}
