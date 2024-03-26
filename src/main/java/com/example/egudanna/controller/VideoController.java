package com.example.egudanna.controller;

import com.example.egudanna.domain.Video;
import com.example.egudanna.dto.video.AddVideoRequest;
import com.example.egudanna.dto.video.VideoResponse;
import com.example.egudanna.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/api/videos")
    public ResponseEntity<Video> addVideo(@RequestBody AddVideoRequest request) {
        Video savedVideo = videoService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedVideo);
    }

    @GetMapping("/api/videos")
    public ResponseEntity<List<VideoResponse>> findAllVideos() {
        List<VideoResponse> videos = videoService.findAll()
                .stream()
                .map(VideoResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(videos);
    }

    @GetMapping("/api/videos/{id}")
    public ResponseEntity<VideoResponse> findVideo(@PathVariable("id") Long id) {
        Video video = videoService.findById(id);

        return ResponseEntity.ok()
                .body(new VideoResponse(video));
    }
}
