package main.java.com.luce.auth.service;

import com.luce.auth.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String register(UserDTO user) {
        // Simula registro (futuro: persistência em banco de dados)
        return "Usuário '" + user.getUsername() + "' registrado com sucesso.";
    }

    public String login(UserDTO user) {
        // Simula autenticação (futuro: verificação + JWT)
        return "Login realizado com sucesso. Token simulado para '" + user.getUsername() + "'";
    }
}
