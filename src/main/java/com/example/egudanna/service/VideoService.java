package com.example.egudanna.service;

import com.example.egudanna.domain.Video;
import com.example.egudanna.dto.video.AddVideoRequest;
import com.example.egudanna.dto.video.UpdateVideoRequest;
import com.example.egudanna.repository.VideoRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Video update(Long id, UpdateVideoRequest request) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        video.update(
                request.getVideoUrl(),
                request.getLevelId(),
                request.getCategoryId()
                );

        return video;
    }

    public void delete(Long id) {
        videoRepository.deleteById(id);
    }
}
