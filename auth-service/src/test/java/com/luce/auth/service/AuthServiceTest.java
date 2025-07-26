package com.luce.auth.service;

import com.luce.auth.model.User;
import com.luce.auth.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull; 
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    @Test
    void deveRegistrarUtilizadorComSucesso() {
        // Arrange
        User userParaRegistrar = new User(null, "testuser", "password");
        User userSalvo = new User(1L, "testuser", "password");

        when(userRepository.save(any(User.class))).thenReturn(userSalvo);

        // Act
        User resultado = authService.register(userParaRegistrar);

        // Assert
        assertEquals("testuser", resultado.getUsername());
        assertNotNull(resultado.getId()); // Esta linha agora funcionará
    }
}