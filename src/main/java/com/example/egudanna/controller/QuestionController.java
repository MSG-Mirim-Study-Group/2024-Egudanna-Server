package com.example.egudanna.controller;

import com.example.egudanna.domain.Question;
import com.example.egudanna.dto.Question.AddQuestionRequest;
import com.example.egudanna.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<Void> createQuestion(@RequestBody AddQuestionRequest addQuestionRequest) {
        questionService.createQuestion(addQuestionRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Question>> findAllQuestions() {
        List<Question> questions = questionService.findAll();
        return ResponseEntity.ok().body(questions);
    }

}
