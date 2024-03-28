package com.example.egudanna.service;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.challenge.ChallengeResponse;
import com.example.egudanna.dto.challenge.UpdateChallengeRequest;
import com.example.egudanna.repository.ChallengeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public Challenge save(AddChallengeRequest request) {
        return challengeRepository.save(request.toEntity());
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

        challenge.update(
                request.getVideoId(),
                request.getLikeNum(),
                request.getLevelId(),
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
