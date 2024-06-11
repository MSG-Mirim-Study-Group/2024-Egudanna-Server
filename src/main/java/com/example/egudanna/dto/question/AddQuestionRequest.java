package com.example.egudanna.dto.question;

import com.example.egudanna.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddQuestionRequest {

    private String question;

    public Question toEntity() {
        return Question.builder()
                .question(question)
                .build();
    }
}
