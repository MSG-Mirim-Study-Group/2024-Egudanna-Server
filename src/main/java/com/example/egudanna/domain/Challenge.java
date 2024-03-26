package com.example.egudanna.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "hashtag", nullable = false)
    private String hashtag;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public void update(Long videoId, Long likeNum, Long levelId, String title, String nickname, String hashtag, String email, String password) {
        this.videoId = videoId;
        this.likeNum = likeNum;
        this.levelId = levelId;
        this.title = title;
        this.nickname = nickname;
        this.hashtag = hashtag;
        this.email = email;
        this.password = password;
    }
}
