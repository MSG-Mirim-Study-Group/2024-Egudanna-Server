package com.example.egudanna.dto.challenge;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.dto.comment.CommentResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class ChallengeResponse {
    private Long id;
    private String videoUrl;
    private Long likeNum;
    private String title;
    private String nickname;
    private String hashtag;
    private String email;
    private List<CommentResponse> comments;

    public ChallengeResponse(Challenge challenge) {
        this.id = challenge.getId();
        this.videoUrl = challenge.getVideoUrl();
        this.likeNum = challenge.getLikeNum();
        this.title = challenge.getTitle();
        this.nickname = challenge.getNickname();
        this.hashtag = challenge.getHashtag();
        this.email = challenge.getEmail();
    }

    public ChallengeResponse(Challenge challenge, List<CommentResponse> comments) {
        this.id = challenge.getId();
        this.videoUrl = challenge.getVideoUrl();
        this.likeNum = challenge.getLikeNum();
        this.title = challenge.getTitle();
        this.nickname = challenge.getNickname();
        this.hashtag = challenge.getHashtag();
        this.email = challenge.getEmail();
        this.comments = comments;
    }
}
