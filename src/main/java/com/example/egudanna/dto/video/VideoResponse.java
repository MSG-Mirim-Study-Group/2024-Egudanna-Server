package com.example.egudanna.dto.video;

import com.example.egudanna.domain.Video;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class VideoResponse {
    private Long videoId;
    private String videoUrl;
    private Long categoryId;
    private Long levelId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public VideoResponse(Video video) {
        this.videoId = video.getId();
        this.videoUrl = video.getVideoUrl();
        this.categoryId = video.getCategory().getId();
        this.levelId = video.getLevel().getId();
        this.createdAt = video.getCreatedAt();
        this.updatedAt = video.getUpdatedAt();
    }
}
