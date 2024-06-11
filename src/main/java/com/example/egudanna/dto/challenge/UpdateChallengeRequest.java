package com.example.egudanna.dto.challenge;

import com.example.egudanna.domain.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateChallengeRequest {
    private Long videoId;
    private Long likeNum;
    private Long levelId;
    private String title;
    private String nickname;
    private String hashtag;
    private String email;
    private String password;
}
