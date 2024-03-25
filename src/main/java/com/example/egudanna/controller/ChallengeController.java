package com.example.egudanna.controller;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("/api/challenges")
    public ResponseEntity<Challenge> addChallenge(@RequestBody AddChallengeRequest request) {
        Challenge savedChallenge = challengeService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedChallenge);
    }
}
