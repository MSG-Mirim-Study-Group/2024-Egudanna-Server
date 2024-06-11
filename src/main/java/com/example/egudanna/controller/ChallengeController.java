package com.example.egudanna.controller;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.challenge.ChallengeResponse;
import com.example.egudanna.dto.challenge.UpdateChallengeRequest;
import com.example.egudanna.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("/api/challenges")
    public ResponseEntity<Map<String, Object>> addChallenge(@RequestBody AddChallengeRequest request) {
        Challenge savedChallenge = challengeService.save(request);

        Map<String, Object> response = new HashMap<>();
        response.put("id", savedChallenge.getId());
        response.put("message", "영상 업로드가 완료되었습니다.");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/api/challenges")
    public ResponseEntity<List<ChallengeResponse>> findAllChallenges() {
        List<ChallengeResponse> challenges = challengeService.findAll()
                .stream()
                .map(ChallengeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(challenges);
    }

    @GetMapping("/api/challenges/{id}")
    public ResponseEntity<ChallengeResponse> findChallenge(@PathVariable("id") Long id) {
        Challenge challenge = challengeService.findById(id);

        return ResponseEntity.ok()
                .body(new ChallengeResponse(challenge));
    }

    @PutMapping("/api/challenges/{id}")
    public ResponseEntity<Map<String, Object>> updateChallenge(@PathVariable("id") Long id,
                                         @RequestBody UpdateChallengeRequest request) {
        Challenge updatedChallenge = challengeService.update(id, request);

        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("message", "영상 수정이 완료되었습니다.");

        return ResponseEntity.ok()
                .body(response);
    }

    @DeleteMapping("/api/challenges/{id}")
    public ResponseEntity<Map<String, Object>> deleteChallenge(@PathVariable("id") Long id) {
        challengeService.delete(id);

        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("message", "영상 삭제가 완료되었습니다.");

        return ResponseEntity.ok()
                .body(response);
    }
}
