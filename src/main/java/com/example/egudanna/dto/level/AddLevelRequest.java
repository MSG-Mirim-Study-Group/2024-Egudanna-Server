package com.example.egudanna.dto.level;

import com.example.egudanna.domain.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddLevelRequest {
    private Integer level;

    public Level toEntity() {
        return Level.builder()
                .level(level)
                .build();
    }
}
