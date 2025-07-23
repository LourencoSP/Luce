package com.luce.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luce.auth.model.User;
import com.luce.auth.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // Utilitário para converter objetos para JSON

    @MockBean
    private AuthService authService;

    @Test
    void deveRegistrarUtilizadorERetornarStatusCreated() throws Exception {
        // Arrange
        User userParaRegistrar = new User(null, "testuser", "password");
        User userSalvo = new User(1L, "testuser", "password");

        when(authService.register(any(User.class))).thenReturn(userSalvo);

        // Act & Assert
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userParaRegistrar)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("testuser"));
    }
}