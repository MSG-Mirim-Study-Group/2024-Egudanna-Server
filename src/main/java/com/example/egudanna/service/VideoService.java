package com.example.egudanna.service;

import com.example.egudanna.domain.Video;
import com.example.egudanna.dto.video.AddVideoRequest;
import com.example.egudanna.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public Video save(AddVideoRequest request) {
        return videoRepository.save(request.toEntity());
    }

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public Video findById(Long id) {
        return videoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: "+id));
    }
}
