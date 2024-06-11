package com.example.egudanna.controller;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.challenge.ChallengeResponse;
import com.example.egudanna.dto.challenge.DeleteChallengeRequest;
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
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> addChallenge(@RequestBody AddChallengeRequest request) {
        // videoUrl 검증
        if (request.getVideoUrl() == null || request.getVideoUrl().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "videoUrl must not be null or empty"));
        }

        if (request.getLevelId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Level ID must not be null"));
        }

        Challenge savedChallenge = challengeService.save(request);

        Map<String, Object> response = new HashMap<>();
        response.put("id", savedChallenge.getId());
        response.put("message", "영상 업로드가 완료되었습니다.");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChallengeResponse>> findAllChallenges() {
        List<ChallengeResponse> challenges = challengeService.findAll()
                .stream()
                .map(ChallengeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(challenges);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChallengeResponse> findChallenge(@PathVariable("id") Long id) {
        Challenge challenge = challengeService.findById(id);

        return ResponseEntity.ok()
                .body(new ChallengeResponse(challenge));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChallengeResponse> updateChallenge(@PathVariable("id") Long id,
                                                               @RequestBody UpdateChallengeRequest request) {
        Challenge updatedChallenge = challengeService.update(id, request);

        return ResponseEntity.ok()
                .body(new ChallengeResponse(updatedChallenge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteChallenge(@PathVariable("id") Long id,
                                                               @RequestBody DeleteChallengeRequest request) {
        challengeService.delete(id, request.getPassword());

        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("message", "영상 삭제가 완료되었습니다.");

        return ResponseEntity.ok()
                .body(response);
    }
}
