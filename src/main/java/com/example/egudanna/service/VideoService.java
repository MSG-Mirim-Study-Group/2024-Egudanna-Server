package com.example.egudanna.service;

import com.example.egudanna.domain.Video;
import com.example.egudanna.dto.challenge.AddChallengeRequest;
import com.example.egudanna.dto.video.AddVideoRequest;
import com.example.egudanna.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public Video save(AddVideoRequest request) {
        return videoRepository.save(request.toEntity());
    }
}
