package com.luce.video.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luce.video.model.Video;
import com.luce.video.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VideoController.class)
class VideoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // Helper para converter objetos para JSON

    @MockBean
    private VideoService videoService;

    @Test
    void deveRetornarListaDeVideosEStatusOK() throws Exception {
        // Arrange
        when(videoService.getAllVideos()).thenReturn(
            List.of(new Video(1L, "Matrix", "Ação", "http://example.com/matrix.mp4"))
        );

        // Act & Assert
        mockMvc.perform(get("/videos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Matrix"));
    }

    // TESTE ATUALIZADO PARA O NOVO MÉTODO POST
    @Test
    void deveRegistarVideoERetornarStatusCreated() throws Exception {
        // Arrange
        Video videoParaRegistar = new Video("O Rei Leão", "Animação", "http://example.com/rei-leao.mp4");
        Video videoSalvo = new Video(1L, "O Rei Leão", "Animação", "http://example.com/rei-leao.mp4");

        when(videoService.saveVideo(any(Video.class))).thenReturn(videoSalvo);

        // Act & Assert
        mockMvc.perform(post("/videos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(videoParaRegistar))) // Converte o objeto para JSON
                .andExpect(status().isCreated()) // Esperamos um status 201 Created
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("O Rei Leão"));
    }
}