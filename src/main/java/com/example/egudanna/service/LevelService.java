package com.example.egudanna.service;

import com.example.egudanna.domain.Level;
import com.example.egudanna.dto.level.LevelResponse;
import com.example.egudanna.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public Level createLevel(LevelResponse addLevelRequest) {
        Level level1 = new Level();
        level1.setLevel(addLevelRequest.getLevel());

        return levelRepository.save(level1);
    }

    public Level getLevelById(Long id) {
        return levelRepository.findById(id).orElse(null);
    }

    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }
}
