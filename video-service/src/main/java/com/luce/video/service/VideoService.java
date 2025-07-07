package com.luce.video.service;

import com.luce.video.model.Video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    public List<Video> getAllVideos() {
        return List.of(
            new Video("A Origem", "Sci-Fi"),
            new Video("Clube da Luta", "Drama"),
            new Video("Matrix", "Ação")
        );
    }
}
