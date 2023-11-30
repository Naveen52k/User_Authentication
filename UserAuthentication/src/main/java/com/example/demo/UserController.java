package com.example.demo;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 

import com.example.demo.service.UserService;

@RestController 
public class UserController {
    
    @Autowired
    UserService userSer;

    @PostMapping("/userExists")
    public ResponseEntity<String> login(@RequestBody User user) { 
        if (userSer.userExistsInDatabase(user)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
