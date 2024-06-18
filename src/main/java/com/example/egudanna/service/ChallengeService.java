package com.example.egudanna.service;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Comment;
import com.example.egudanna.domain.Level;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.challenge.UpdateChallengeRequest;
import com.example.egudanna.repository.ChallengeRepository;
import com.example.egudanna.repository.CommentRepository;
import com.example.egudanna.repository.LevelRepository;
import com.example.egudanna.service.email.EmailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final LevelRepository levelRepository;
    private final CommentRepository commentRepository;
    private final EmailService emailService;

    public Challenge save(AddChallengeRequest request) {
        Level level = levelRepository.findById(request.getLevelId())
                .orElseThrow(() -> new IllegalArgumentException("Level not found: " + request.getLevelId()));
        return challengeRepository.save(request.toEntity(level));
    }

    public List<Challenge> findAll() {
        return challengeRepository.findAll();
    }

    public Challenge findById(Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public Challenge findByIdWithComments(Long id) {
        Challenge challenge = findById(id);
        List<Comment> comments = commentRepository.findAllByChallengeId(id);
        challenge.setComments(comments);  // Challenge 엔티티에 setComments 메서드 추가 필요
        return challenge;
    }

    @Transactional
    public Challenge update(Long id, UpdateChallengeRequest request) {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        Level level = levelRepository.findById(request.getLevelId())
                .orElseThrow(() -> new IllegalArgumentException("Level not found: " + id));
        challenge.update(
                request.getLikeNum(),
                level,
                request.getTitle(),
                request.getNickname(),
                request.getHashtag(),
                request.getEmail(),
                request.getPassword());

        return challenge;
    }

    public void delete(Long id, String password) {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        if (!challenge.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        challengeRepository.deleteById(id);
    }

    @Transactional
    public Challenge incrementLikeNum(Long id) {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Challenge not found: " + id));
        challenge.setLikeNum(challenge.getLikeNum() + 1);
        return challengeRepository.save(challenge);
    }
}
