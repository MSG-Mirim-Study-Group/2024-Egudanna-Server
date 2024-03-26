package com.example.egudanna.dto.video;

import com.example.egudanna.domain.Video;
import lombok.Getter;

@Getter
public class VideoResponse {
    private Long videoId;
    private String videoUrl;
    private Long categoryId;
    private Long levelId;

    public VideoResponse(Video video) {
        this.videoId = video.getVideoId();
        this.videoUrl = video.getVideoUrl();
        this.categoryId = video.getCategoryId();
        this.levelId = video.getLevelId();
    }
}
