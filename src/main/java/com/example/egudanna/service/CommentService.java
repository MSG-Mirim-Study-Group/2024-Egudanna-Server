package com.example.egudanna.service;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Comment;
import com.example.egudanna.dto.comment.AddCommentRequest;
import com.example.egudanna.repository.ChallengeRepository;
import com.example.egudanna.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ChallengeRepository challengeRepository;

    public Comment save(AddCommentRequest request) {
        Challenge challenge = challengeRepository.findById(request.getChallenge().getId())
                .orElseThrow(() -> new IllegalArgumentException("Challenge Id not found: "+request.getChallenge().getId()));
        Comment comment = request.toEntity(challenge);
        return commentRepository.save(comment);
    }

    public List<Comment> findAllByChallengeId(Long challengeId) {
        return commentRepository.findAllByChallengeId(challengeId);
    }
}
