package com.example.UserApplication.Service;

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
public class DeleteUserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public ResponseEntity<String> deleteUser(int userId) throws Exception {
        try{
            String message = "Deleted usesr " + userRepository.findById(userId).get().getUserName() + " deleted successfully";
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(message,httpHeaders, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new Exception("Error occurred during execution of DeleteUserService");
        }
        finally {
            System.out.println("Execution of DeleteUserService is done");
        }
    }
}
