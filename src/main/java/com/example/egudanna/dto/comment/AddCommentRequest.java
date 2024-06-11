package com.example.egudanna.dto.comment;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddCommentRequest {
    private Challenge challenge;
    private String comment;

    public Comment toEntity(Challenge challenge) {
        return Comment.builder()
                .challenge(challenge)
                .comment(comment)
                .build();
    }
}
