package com.example.egudanna.dto.challenge;


import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Level;
import com.example.egudanna.domain.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddChallengeRequest {
    private Video video;
    private Level level;
    private Long likeNum;
    private String title;
    private String nickname;
    private String hashtag;
    private String videoUrl;
    private String email;
    private String password;

    public Challenge toEntity(Video video, Level level) {
        return Challenge.builder()
                .video(video)
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
