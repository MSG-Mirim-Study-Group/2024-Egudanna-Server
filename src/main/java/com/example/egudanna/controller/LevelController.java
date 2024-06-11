package com.example.egudanna.controller;

import com.example.egudanna.domain.Level;
import com.example.egudanna.dto.level.AddLevelRequest;
import com.example.egudanna.dto.level.LevelResponse;
import com.example.egudanna.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/levels")
public class LevelController {

    private final LevelService levelService;

    @PostMapping
    public ResponseEntity<LevelResponse> addLevel(@RequestBody AddLevelRequest request) {
        Level savedLevel = levelService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LevelResponse(savedLevel));
    }

    @GetMapping("/{level_id}")
    public ResponseEntity<LevelResponse> findLevel(@PathVariable("level_id") Long id) {
        Level level = levelService.findById(id);

        return ResponseEntity.ok()
                .body(new LevelResponse(level));
    }

    @GetMapping
    public ResponseEntity<List<LevelResponse>> findAllLevels() {
        List<LevelResponse> levels = levelService.findAll()
                .stream()
                .map(LevelResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(levels);
    }

}
