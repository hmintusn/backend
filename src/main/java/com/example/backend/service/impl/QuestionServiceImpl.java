package com.example.backend.service.impl;

import com.example.backend.model.Question;
import com.example.backend.repository.QuestionRepository;
import com.example.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

//    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

//    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
