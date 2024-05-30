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

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "hashtag", nullable = false)
    private String hashtag;

    @Column(name = "video_url", nullable = false, length = 20000)
    private String videoUrl;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public void update(Long videoId, Long likeNum, Level level, String title, String nickname, String hashtag, String videoUrl, String email, String password) {
        this.videoId = videoId;
        this.likeNum = likeNum;
        this.level = level;
        this.title = title;
        this.nickname = nickname;
        this.hashtag = hashtag;
        this.videoUrl = videoUrl;
        this.email = email;
        this.password = password;
    }
}
