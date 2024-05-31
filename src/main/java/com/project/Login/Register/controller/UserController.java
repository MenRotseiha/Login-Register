package com.project.Login.Register.controller;

import com.project.Login.Register.model.User;
import com.project.Login.Register.repository.UserRepository;
import com.project.Login.Register.service.Imp.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping
@CrossOrigin
public class UserController {
    private final UserServiceImp userServiceImp;
    private final UserRepository userRepository;
    @PostMapping("/register")
    public String register(@RequestBody User user){
        userServiceImp.saveUser(user);
        return "New User is added.";
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user){
        Optional<User> foundUser=userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if(foundUser.isPresent()){
            return ResponseEntity.accepted().body("hello there");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
