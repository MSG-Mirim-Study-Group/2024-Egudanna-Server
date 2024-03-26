package com.example.egudanna.dto.video;


import com.example.egudanna.domain.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddVideoRequest {
    private Long videoId;
    private String videoUrl;
    private Long categoryId;
    private Long levelId;

    public Video toEntity() {
        return Video.builder()
                .videoId(videoId)
                .videoUrl(videoUrl)
                .categoryId(categoryId)
                .levelId(levelId)
                .build();
    }
}
