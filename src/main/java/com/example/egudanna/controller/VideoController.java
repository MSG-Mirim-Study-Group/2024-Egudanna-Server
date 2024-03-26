package com.example.egudanna.controller;

import com.example.egudanna.domain.Video;
import com.example.egudanna.dto.video.AddVideoRequest;
import com.example.egudanna.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
