package com.example.egudanna.controller;

import com.example.egudanna.domain.Level;
import com.example.egudanna.dto.level.LevelResponse;
import com.example.egudanna.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/level")
public class LevelController {
    private final LevelService levelService;

    @PostMapping
    public ResponseEntity<Level> createLevel(@RequestBody LevelResponse addLevelRequest) {
        levelService.createLevel(addLevelRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{level_id}")
    public ResponseEntity<LevelResponse> getLevel(@PathVariable("level_id") Long level_id) {
        Level level = levelService.getLevelById(level_id);
        LevelResponse response = new LevelResponse(level.getLevel());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Level>> getLevels() {
        List<Level> level = levelService.getAllLevels();
        return ResponseEntity.ok().body(level);
    }

}
