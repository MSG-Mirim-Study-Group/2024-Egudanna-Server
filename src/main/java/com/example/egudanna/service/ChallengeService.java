package com.example.egudanna.service;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Level;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.challenge.UpdateChallengeRequest;
import com.example.egudanna.repository.ChallengeRepository;
import com.example.egudanna.repository.LevelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final LevelRepository levelRepository;

    public Challenge save(AddChallengeRequest request) {
        Level level = levelRepository.findLevelById(request.getLevelId());
        return challengeRepository.save(request.toEntity(level));
    }

    public List<Challenge> findAll() {
        return challengeRepository.findAll();
    }

    public Challenge findById(Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found "+id));
    }

    @Transactional
    public Challenge update(Long id, UpdateChallengeRequest request) {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));
        Level level = levelRepository.findById(request.getLevelId()).orElse(null);
        challenge.update(
                request.getVideoId(),
                request.getLikeNum(),
                level,
                request.getTitle(),
                request.getNickname(),
                request.getHashtag(),
                request.getVideoUrl(),
                request.getEmail(),
                request.getPassword());

        return challenge;
    }

    public void delete(Long id) {
        challengeRepository.deleteById(id);
    }
}
