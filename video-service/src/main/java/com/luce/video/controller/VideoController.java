package main.java.com.luce.video.controller;

import com.luce.video.model.Video;
import com.luce.video.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService service;

    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Video> getVideos() {
        return service.getAllVideos();
    }
}
