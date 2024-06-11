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
    @Column(name = "challengeId", updatable = false, nullable = false)
    private Long id;

    @Column(name = "videoUrl", updatable = false, nullable = false, length = 20000)
    private String videoUrl;

    @Column(name = "likeNum")
    private Long likeNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "levelId", nullable = false)
    private Level level;

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

    public void update(String videoUrl, Long likeNum, Level level, String title, String nickname, String hashtag, String email, String password) {
        this.videoUrl = videoUrl;
        this.likeNum = likeNum;
        this.level = level;
        this.title = title;
        this.nickname = nickname;
        this.hashtag = hashtag;
        this.email = email;
        this.password = password;
    }
}
