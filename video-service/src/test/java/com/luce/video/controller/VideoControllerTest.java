package com.luce.video.controller;

import com.luce.video.model.Video;
import com.luce.video.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VideoController.class)
class VideoControllerTest {

    @Autowired
    private MockMvc mockMvc; // Ferramenta para simular pedidos HTTP

    @MockBean // Cria uma versão simulada do VideoService
    private VideoService videoService;

    @Test
    void deveRetornarListaDeVideosEStatusOK() throws Exception {
        // Arrange (Preparação)
        // Dizemos ao nosso service simulado o que ele deve retornar
        when(videoService.getAllVideos()).thenReturn(
            List.of(new Video(1L, "Matrix", "Ação"))
        );

        // Act & Assert (Ação e Verificação)
        mockMvc.perform(get("/videos") // Faz um pedido GET para o endpoint /videos
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Esperamos um status 200 OK
                .andExpect(jsonPath("$[0].title").value("Matrix")) // Verificamos se o primeiro item da lista tem o título "Matrix"
                .andExpect(jsonPath("$.length()").value(1)); // Verificamos se a lista tem tamanho 1
    }
}