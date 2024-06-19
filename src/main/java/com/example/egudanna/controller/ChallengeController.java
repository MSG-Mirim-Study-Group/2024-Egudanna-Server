package com.example.egudanna.controller;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.challenge.ChallengeResponse;
import com.example.egudanna.dto.challenge.DeleteChallengeRequest;
import com.example.egudanna.dto.challenge.UpdateChallengeRequest;
import com.example.egudanna.dto.comment.CommentResponse;
import com.example.egudanna.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Challenge challenge = challengeService.findByIdWithComments(id);
        List<CommentResponse> comments = challenge.getComments().stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());

        ChallengeResponse response = new ChallengeResponse(challenge, comments);

        return ResponseEntity.ok()
                .body(response);
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

    @PostMapping("/{id}/like")
    public ResponseEntity<Map<String, Object>> incrementLikeNum(@PathVariable("id") Long id) {
        Challenge updatedChallenge = challengeService.incrementLikeNum(id);

        Map<String, Object> response = new HashMap<>();
        response.put("id", updatedChallenge.getId());
        response.put("likeNum", updatedChallenge.getLikeNum());
        response.put("message", "Like number has been incremented.");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ChallengeResponse>> searchChallenges(@RequestParam("keyword") String keyword) {
        List<ChallengeResponse> challenges = challengeService.searchChallenges(keyword)
                .stream()
                .map(ChallengeResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(challenges);
    }
}
