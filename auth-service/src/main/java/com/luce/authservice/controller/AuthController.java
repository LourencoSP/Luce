package com.luce.authservice.controller;
import com.luce.authservice.dto.LoginRequest;
import com.luce.authservice.dto.RegisterRequest;
import com.luce.authservice.dto.JwtResponse;
import com.luce.authservice.model.User;
import com.luce.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}