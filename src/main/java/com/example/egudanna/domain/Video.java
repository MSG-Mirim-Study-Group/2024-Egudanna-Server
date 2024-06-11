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
    @Column(name = "videoId", updatable = false, nullable = false)
    private Long id;

    @Column(name = "video_url", length = 20000)
    private String videoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "levelId", nullable = false)
    private Level level;

    public void update(String videoUrl, Category category, Level level) {
        this.videoUrl = videoUrl;
        this.category = category;
        this.level = level;
    }
}
