package com.example.egudanna.dto.video;


import com.example.egudanna.domain.Video;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddVideoRequest {
    private Long id;
    private String videoUrl;
    private Long categoryId;
    private Long levelId;

    public Video toEntity() {
        return Video.builder()
                .id(id)
                .videoUrl(videoUrl)
                .categoryId(categoryId)
                .levelId(levelId)
                .build();
    }
}
