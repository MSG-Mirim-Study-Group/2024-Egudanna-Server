package com.example.egudanna.dto.video;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateVideoRequest {
    private Long videoId;
    private String videoUrl;
    private Long categoryId;
    private Long levelId;
}
