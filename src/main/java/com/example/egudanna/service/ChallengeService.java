package com.example.egudanna.service;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Level;
import com.example.egudanna.domain.Video;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.challenge.UpdateChallengeRequest;
import com.example.egudanna.repository.ChallengeRepository;
import com.example.egudanna.repository.LevelRepository;
import com.example.egudanna.repository.VideoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final VideoRepository videoRepository;
    private final LevelRepository levelRepository;

    public Challenge save(AddChallengeRequest request) {
        Video video = videoRepository.findById(request.getVideo().getId())
                .orElseThrow(() -> new IllegalArgumentException("Video not found: "+request.getVideo().getId()));
        Level level = levelRepository.findById(request.getLevel().getId())
                .orElseThrow(() -> new IllegalArgumentException("Level not found: "+request.getLevel().getId()));
        return challengeRepository.save(request.toEntity(video, level));
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
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Video not found: " + id));
        Level level = levelRepository.findById(request.getLevelId())
                .orElseThrow(() -> new IllegalArgumentException("Level not found: " + id));
        challenge.update(
                video,
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
