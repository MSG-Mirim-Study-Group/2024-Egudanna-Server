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

    public Question createQuestion(AddQuestionRequest addQuestionRequest) {
        Question question1 = new Question();
        question1.setQuestion(addQuestionRequest.getQuestion());

        return questionRepository.save(question1);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

}