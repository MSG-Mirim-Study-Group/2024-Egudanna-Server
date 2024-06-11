package com.example.egudanna.dto.video;


import com.example.egudanna.domain.Category;
import com.example.egudanna.domain.Level;
import com.example.egudanna.domain.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddVideoRequest {
    private Category category;
    private Level level;
    private String videoUrl;

    public Video toEntity(Category category, Level level) {
        return Video.builder()
                .videoUrl(videoUrl)
                .category(category)
                .level(level)
                .build();
    }
}
