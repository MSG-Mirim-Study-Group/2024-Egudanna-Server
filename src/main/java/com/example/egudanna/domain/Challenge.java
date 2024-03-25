package com.example.egudanna.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "challenges")
public class Challenge extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @CollectionTable(name = "videos", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "video_id")
    private Long videoId;

    @Column(name = "like_num")
    private Long likeNum;

    @CollectionTable(name = "levels", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "level_id")
    private Long levelId;

    @Column(name = "title")
    private String title;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "hashtag")
    private String hashtag;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
