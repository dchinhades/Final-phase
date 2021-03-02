package com.example.UserApplication.Service;

import com.example.UserApplication.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Data
public class GetUserByUserIdService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public ResponseEntity<Object> getUserByUserId(int userId) throws Exception {
        try{
            Object user = userRepository.findById(userId);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            return ResponseEntity.ok().headers(httpHeaders).body(user);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during execution of GetUserByUserIdService");
        }
        finally {
            System.out.println("Execution of GetUserByUserIdServices is done");
        }
    }
}
