package com.luce.auth.service;

import com.luce.auth.model.User;
import com.luce.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    // Futuramente, adicionaríamos: private final PasswordEncoder passwordEncoder;
    // Futuramente, adicionaríamos: private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        // Futuramente, a senha seria encriptada antes de guardar
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(User user) {
        // A lógica de login real seria mais complexa, verificando a senha
        // e depois gerando um token. Por agora, mantemos a simulação.
        return "fake-jwt-token-for-" + user.getUsername();
    }
}