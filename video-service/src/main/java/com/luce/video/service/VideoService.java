package com.luce.video.service;

import com.luce.video.model.Video;
import com.luce.video.repository.VideoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    // LÓGICA ALTERADA: Já não faz upload, apenas salva o objeto
    public Video saveVideo(Video video) {
        if (video.getUrl() == null || video.getUrl().isBlank()) {
            throw new IllegalArgumentException("URL do vídeo não pode ser vazia.");
        }
        return videoRepository.save(video);
    }
}