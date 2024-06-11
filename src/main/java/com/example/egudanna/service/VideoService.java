package com.example.egudanna.service;

import com.example.egudanna.domain.Category;
import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Level;
import com.example.egudanna.domain.Video;
import com.example.egudanna.dto.video.AddVideoRequest;
import com.example.egudanna.dto.video.UpdateVideoRequest;
import com.example.egudanna.repository.CategoryRepository;
import com.example.egudanna.repository.LevelRepository;
import com.example.egudanna.repository.VideoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final LevelRepository levelRepository;
    private final CategoryRepository categoryRepository;

    public Video save(AddVideoRequest request) {
        Category category = categoryRepository.findById(request.getCategory().getId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found: "+request.getCategory().getId()));
        Level level = levelRepository.findById(request.getLevel().getId())
                .orElseThrow(() -> new IllegalArgumentException("Level not found: "+request.getLevel().getId()));
        return videoRepository.save(request.toEntity(category, level));
    }

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public Video findById(Long id) {
        return videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    @Transactional
    public Video update(Long id, UpdateVideoRequest request) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Video not found: " + id));
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found: " + id));
        Level level = levelRepository.findById(request.getLevelId())
                .orElseThrow(() -> new IllegalArgumentException("Level not found: " + id));
        video.update(
                request.getVideoUrl(),
                category,
                level
        );

        return video;
    }

    public void delete(Long id) {
        videoRepository.deleteById(id);
    }
}
