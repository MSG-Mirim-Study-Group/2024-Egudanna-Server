package com.example.egudanna.dto.challenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateChallengeRequest {
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
}
