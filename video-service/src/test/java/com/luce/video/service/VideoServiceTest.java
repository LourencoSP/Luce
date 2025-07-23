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
                new Video(1L, "Matrix", "Ação"),
                new Video(2L, "A Origem", "Sci-Fi")
        ));

        // Act
        List<Video> resultado = videoService.getAllVideos();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("Matrix", resultado.get(0).getTitle());
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaVideos() {
        // Arrange
        when(videoRepository.findAll()).thenReturn(List.of());

        // Act
        List<Video> resultado = videoService.getAllVideos();

        // Assert
        assertTrue(resultado.isEmpty());
    }
}