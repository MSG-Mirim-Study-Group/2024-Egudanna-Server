package com.example.egudanna.dto.comment;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Comment;
import lombok.Getter;

@Getter
public class CommentResponse {
    private Long commentId;
    private Long challengeId;
    private String nickname;
    private String comment;

    public CommentResponse(Comment comment) {
        this.commentId = comment.getId();
        this.challengeId = comment.getChallenge().getId();
        this.nickname = comment.getNickname();
        this.comment = comment.getComment();
    }
}
