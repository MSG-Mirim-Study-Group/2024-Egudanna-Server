package com.example.egudanna.service;

import com.example.egudanna.domain.Question;
import com.example.egudanna.dto.question.AddQuestionRequest;
import com.example.egudanna.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Question save(AddQuestionRequest request) {
        return questionRepository.save(request.toEntity());
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Question Id not found: "+id));
    }
}