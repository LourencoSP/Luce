package com.luce.auth.controller;

import com.luce.auth.model.UserDTO;
import com.luce.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO user) {
        authService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully: " + user.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserDTO user) {
        String token = authService.login(user);
        Map<String, String> response = Map.of("token", token);
        return ResponseEntity.ok(response);
    }
}