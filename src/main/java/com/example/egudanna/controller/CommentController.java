package com.example.egudanna.controller;

import com.example.egudanna.domain.Comment;
import com.example.egudanna.dto.comment.AddCommentRequest;
import com.example.egudanna.dto.comment.CommentResponse;
import com.example.egudanna.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponse> addComment(@RequestBody AddCommentRequest request) {
        Comment savedComment = commentService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CommentResponse(savedComment));
    }

    @GetMapping("/{challenge_id}")
    public ResponseEntity<List<CommentResponse>> findAllComments(@PathVariable("challenge_id") Long challengeId) {
        List<Comment> comments = commentService.findAllByChallengeId(challengeId);
        List<CommentResponse> responses = comments.stream()
                .map(CommentResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(responses);
    }
}
