package com.example.egudanna.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@DynamicUpdate
@Entity
@Table(name = "videos")
public class Video extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long videoId;

    @Column(name = "video_url")
    private String videoUrl;

    @CollectionTable(name = "categories", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "category_id")
    private Long categoryId;

    @CollectionTable(name = "levels", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "level_id")
    private Long levelId;

    public void update(String videoUrl, Long categoryId, Long levelId) {
        this.videoUrl = videoUrl;
        this.categoryId = categoryId;
        this.levelId = levelId;
    }
}
