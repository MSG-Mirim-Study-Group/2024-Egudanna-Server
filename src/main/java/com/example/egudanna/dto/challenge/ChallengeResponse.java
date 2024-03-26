package com.example.egudanna.dto.challenge;

import com.example.egudanna.domain.Challenge;
import lombok.Getter;

@Getter
public class ChallengeResponse {
    private Long id;
    private Long videoId;
    private Long likeNum;
    private Long levelId;
    private String title;
    private String nickname;
    private String hashtag;
    private String email;
    private String password;

    public ChallengeResponse(Challenge challenge) {
        this.videoId = getVideoId();
        this.likeNum = getLikeNum();
        this.levelId = getLevelId();
        this.title = getTitle();
        this.nickname = getNickname();
        this.hashtag = getHashtag();
        this.email = getEmail();
        this.password = getPassword();
    }
}
