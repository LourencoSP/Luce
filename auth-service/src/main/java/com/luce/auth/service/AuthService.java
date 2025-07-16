package com.luce.auth.service;

import com.luce.auth.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Simula o registro em um banco de dados (a ser implementado)
    public UserDTO register(UserDTO user) {
        // Aqui você adicionaria a lógica para salvar o usuário em um banco de dados
        // Ex: user.setPassword(passwordEncoder.encode(user.getPassword()));
        //     userRepository.save(user);
        System.out.println("Registering user: " + user.getUsername());
        return user;
    }

    // Simula o login e gera um token JWT (a ser implementado)
    public String login(UserDTO user) {
        // Aqui você validaria o usuário contra o banco de dados
        // e geraria um token se as credenciais estiverem corretas.
        System.out.println("User login: " + user.getUsername());
        // Ex: return jwtUtil.generateToken(user.getUsername());
        return "fake-jwt-token-for-" + user.getUsername();
    }
}