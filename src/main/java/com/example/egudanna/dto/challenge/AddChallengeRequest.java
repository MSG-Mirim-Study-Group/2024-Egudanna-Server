package com.example.egudanna.dto.challenge;


import com.example.egudanna.domain.Challenge;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddChallengeRequest {
    private Long id;
    private Long videoId;
    private Long like;
    private Long levelId;
    private String title;
    private String nickname;
    private String hashtag;
    private String email;
    private String password;

    public Challenge toEntity() {
        return Challenge.builder()
                .id(id)
                .videoId(videoId)
                .like(like)
                .levelId(levelId)
                .title(title)
                .nickname(nickname)
                .hashtag(hashtag)
                .email(email)
                .password(password)
                .build();
    }
}
