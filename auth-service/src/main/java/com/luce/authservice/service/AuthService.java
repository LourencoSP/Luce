package com.luce.authservice.service;
import com.luce.authservice.dto.JwtResponse;
import com.luce.authservice.dto.LoginRequest;
import com.luce.authservice.dto.RegisterRequest;
import com.luce.authservice.model.User;
import com.luce.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    public User register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }
    public JwtResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return new JwtResponse("fake-jwt-token");
    }
}