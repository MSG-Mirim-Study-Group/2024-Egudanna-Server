package com.example.egudanna.dto.level;

import com.example.egudanna.domain.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class LevelResponse {
    private Long levelId;
    private Integer level;

    public LevelResponse(Level level) {
        this.levelId = level.getId();
        this.level = level.getLevel();
    }
}
