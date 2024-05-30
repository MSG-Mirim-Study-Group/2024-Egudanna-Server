package com.example.egudanna.dto.challenge;


import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddChallengeRequest {
    private Long id;
    private Long videoId;
    private Long likeNum;
    private Long levelId;
    private String title;
    private String nickname;
    private String hashtag;
    private String videoUrl;
    private String email;
    private String password;

    public Challenge toEntity(Level level) {
        return Challenge.builder()
                .id(id)
                .videoId(videoId)
                .likeNum(likeNum)
                .level(level)
                .title(title)
                .nickname(nickname)
                .hashtag(hashtag)
                .videoUrl(videoUrl)
                .email(email)
                .password(password)
                .build();
    }
}
