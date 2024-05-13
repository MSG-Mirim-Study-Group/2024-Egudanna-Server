package com.example.egudanna.service;

import com.example.egudanna.domain.Level;
import com.example.egudanna.dto.Level.AddLevelRequest;
import com.example.egudanna.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public Level createLevel(AddLevelRequest addLevelRequest) {
        Level level = new Level();
        level.setLevel(addLevelRequest.getLevel());

        return levelRepository.save(level);
    }

    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }
}
