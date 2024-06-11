package com.example.egudanna.dto.challenge;

import com.example.egudanna.domain.Challenge;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChallengeResponse {
    private Long id;
    private Long levelId;
    private String videoUrl;
    private Long likeNum;
    private String title;
    private String nickname;
    private String hashtag;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public ChallengeResponse(Challenge challenge) {
        this.id = challenge.getId();
        this.videoUrl = challenge.getVideoUrl();
        this.likeNum = challenge.getLikeNum();
        this.levelId = challenge.getLevel().getId();
        this.title = challenge.getTitle();
        this.nickname = challenge.getNickname();
        this.hashtag = challenge.getHashtag();
        this.email = challenge.getEmail();
        this.password = challenge.getPassword();
        this.createdAt = challenge.getCreatedAt();
        this.updatedAt = challenge.getUpdatedAt();
    }
}
