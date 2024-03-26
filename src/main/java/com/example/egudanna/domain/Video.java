package com.example.egudanna.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
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
}
