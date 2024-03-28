package com.example.egudanna.controller;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Video;
import com.example.egudanna.dto.challenge.UpdateChallengeRequest;
import com.example.egudanna.dto.video.AddVideoRequest;
import com.example.egudanna.dto.video.UpdateVideoRequest;
import com.example.egudanna.dto.video.VideoResponse;
import com.example.egudanna.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/api/videos")
    public ResponseEntity<Map<String, Object>> addVideo(@RequestBody AddVideoRequest request) {
        Video savedVideo = videoService.save(request);

        Map<String, Object> response = new HashMap<>();
        response.put("id", savedVideo.getVideoId());
        response.put("message", "참고 영상 업로드가 완료되었습니다.");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
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

    @PutMapping("/api/videos/{id}")
    public ResponseEntity<Map<String, Object>> updateVideo(@PathVariable("id") Long id,
                                                               @RequestBody UpdateVideoRequest request) {
        Video updatedVideo = videoService.update(id, request);

        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("message", "참고 영상 수정이 완료되었습니다.");

        return ResponseEntity.ok()
                .body(response);
    }

    @DeleteMapping("/api/videos/{id}")
    public ResponseEntity<Map<String, Object>> deleteVideo(@PathVariable("id") Long id) {
        videoService.delete(id);

        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("message", "참고 영상 삭제가 완료되었습니다.");

        return ResponseEntity.ok()
                .body(response);
    }
}
