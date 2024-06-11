package com.example.egudanna.controller;

import com.example.egudanna.domain.Question;
import com.example.egudanna.dto.question.AddQuestionRequest;
import com.example.egudanna.dto.question.QuestionResponse;
import com.example.egudanna.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponse> addQuestion(@RequestBody AddQuestionRequest request) {
        Question savedQuestion = questionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new QuestionResponse(savedQuestion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> findQuestion(@PathVariable("id") Long id) {
        Question question = questionService.findById(id);

        return ResponseEntity.ok()
                .body(new QuestionResponse(question));
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> findAllQuestions() {
        List<QuestionResponse> questions = questionService.findAll()
                .stream()
                .map(QuestionResponse::new)
                .toList();
        return ResponseEntity.ok().
                body(questions);
    }

}
