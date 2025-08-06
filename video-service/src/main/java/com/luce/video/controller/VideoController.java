package com.luce.video.controller;

import com.luce.video.model.Video;
import com.luce.video.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService service;

    // A CORREÇÃO ESTÁ AQUI:
    // Estava "VideoController service", o correto é "VideoService service"
    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Video> getVideos() {
        return service.getAllVideos();
    }

    @PostMapping
    public ResponseEntity<Video> registerVideo(@RequestBody Video video) {
        Video savedVideo = service.saveVideo(video);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVideo);
    }
}