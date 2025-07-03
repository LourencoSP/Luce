package main.java.com.luce.auth.controller;

import com.luce.auth.model.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody UserDTO user) {
        return "Usuário registrado: " + user.getUsername();
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO user) {
        return "Token simulado para: " + user.getUsername();
    }
}
