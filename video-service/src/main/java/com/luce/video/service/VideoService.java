package com.luce.video.service;

import com.luce.video.model.Video;
import com.luce.video.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    // Injeção de dependência via construtor (melhor prática)
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        // Agora busca os vídeos da base de dados através do repositório
        return videoRepository.findAll();
    }
}