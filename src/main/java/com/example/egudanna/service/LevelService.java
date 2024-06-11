package com.example.egudanna.service;

import com.example.egudanna.domain.Challenge;
import com.example.egudanna.domain.Level;
import com.example.egudanna.dto.level.AddLevelRequest;
import com.example.egudanna.dto.level.LevelResponse;
import com.example.egudanna.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public Level save(AddLevelRequest request) {
        return levelRepository.save(request.toEntity());
    }

    public Level findById(Long id) {
        return levelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found "+id));
    }

    public List<Level> findAll() {
        return levelRepository.findAll();
    }
}
