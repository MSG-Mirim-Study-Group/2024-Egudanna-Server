package com.example.egudanna.dto.challenge;


import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddChallengeRequest {
    private String videoUrl;
    private Level level;
    private Long likeNum;
    private String title;
    private String nickname;
    private String hashtag;
    private String email;
    private String password;

    public Challenge toEntity(Level level) {
        return Challenge.builder()
                .videoUrl(videoUrl)
                .likeNum(likeNum)
                .level(level)
                .title(title)
                .nickname(nickname)
                .hashtag(hashtag)
                .email(email)
                .password(password)
                .build();
    }
}
