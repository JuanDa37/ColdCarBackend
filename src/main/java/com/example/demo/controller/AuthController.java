package com.example.demo.controller;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

//import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository){
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        User user = userRepository.findByUsername(request.getUsername()).orElse(null);

        if(user == null || !user.getPassword().equals(request.getPassword()) /*|| !passwordEncoder.matches(request.getPassword(), user.getPassword())*/){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(java.util.Map.of(
                "message",
                "Usuario o contraseña incorrectas."
            ));
        }

        String role = user.getRole().name().toUpperCase(Locale.ROOT);

        if(!role.equals("ADMIN") && !role.equals("USER")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(java.util.Map.of(
                "message",
                "El usuario no tiene un rol autorizado."
            ));
        }

        return ResponseEntity.ok(
            new LoginResponse(user.getUsername(), role)
        );
    }

}
