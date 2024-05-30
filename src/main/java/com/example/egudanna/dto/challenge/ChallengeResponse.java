package com.example.egudanna.dto.challenge;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Level;
import lombok.Getter;

@Getter
public class ChallengeResponse {
    private Long id;
    private Long videoId;
    private Long likeNum;
    private Level level;
    private String title;
    private String nickname;
    private String hashtag;
    private String videoUrl;
    private String email;
    private String password;

    public ChallengeResponse(Challenge challenge) {
        this.id = challenge.getId();
        this.videoId = challenge.getVideoId();
        this.likeNum = challenge.getLikeNum();
        this.level = challenge.getLevel();
        this.title = challenge.getTitle();
        this.nickname = challenge.getNickname();
        this.hashtag = challenge.getHashtag();
        this.videoUrl = challenge.getVideoUrl();
        this.email = challenge.getEmail();
        this.password = challenge.getPassword();
    }
}
