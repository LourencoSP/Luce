package com.luce.auth.controller;

import com.luce.auth.model.User; // Alterado de UserDTO para User
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
    public ResponseEntity<User> register(@RequestBody User user) { // Alterado para retornar o User criado
        User registeredUser = authService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) { // Alterado de UserDTO para User
        String token = authService.login(user);
        Map<String, String> response = Map.of("token", token);
        return ResponseEntity.ok(response);
    }
}