package com.example.egudanna.controller;

import com.example.egudanna.domain.Level;
import com.example.egudanna.dto.Level.AddLevelRequest;
import com.example.egudanna.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/level")
public class LevelController {
    private final LevelService levelService;

    @PostMapping
    public ResponseEntity<Void> createLevel(@RequestBody AddLevelRequest addLevelRequest) {
        levelService.createLevel(addLevelRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Level>> getLevels() {
        List<Level> level = levelService.getAllLevels();
        return ResponseEntity.ok().body(level);
    }

}
