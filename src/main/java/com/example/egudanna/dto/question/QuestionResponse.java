package com.example.egudanna.dto.question;

import com.example.egudanna.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class QuestionResponse {

    private Long questionId;
    private String question;
    private String answer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public QuestionResponse(Question question) {
        this.questionId = question.getId();
        this.question = question.getQuestion();
        this.answer = question.getAnswer();
        this.createdAt = question.getCreatedAt();
        this.updatedAt = question.getUpdatedAt();
    }
}
