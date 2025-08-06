package com.luce.video.service;

import com.luce.video.model.Video;
import com.luce.video.repository.VideoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VideoServiceTest {

    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private VideoService videoService;

    @Test
    void deveRetornarTodosOsVideosComSucesso() {
        // Arrange
        when(videoRepository.findAll()).thenReturn(List.of(
                new Video(1L, "Matrix", "Ação", "http://example.com/matrix.mp4")
        ));

        // Act
        List<Video> resultado = videoService.getAllVideos();

        // Assert
        assertEquals(1, resultado.size());
        assertEquals("Matrix", resultado.get(0).getTitle());
    }

    // NOVO TESTE PARA A LÓGICA DE SALVAR
    @Test
    void deveSalvarVideoComUrlCorretamente() {
        // Arrange
        Video videoParaSalvar = new Video("A Origem", "Sci-Fi", "http://example.com/origem.mp4");
        Video videoSalvo = new Video(1L, "A Origem", "Sci-Fi", "http://example.com/origem.mp4");

        when(videoRepository.save(any(Video.class))).thenReturn(videoSalvo);

        // Act
        Video resultado = videoService.saveVideo(videoParaSalvar);

        // Assert
        assertNotNull(resultado.getId());
        assertEquals("http://example.com/origem.mp4", resultado.getUrl());
    }

        @Test
        void deveLancarExcecaoAoSalvarVideoComUrlVazia() {
            // Arrange
        }
    }