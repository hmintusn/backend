package com.example.backend.service;

import com.example.backend.model.Question;

import java.util.List;

public interface QuestionService {
    public Question saveQuestion(Question question);

    public List<Question> saveAllQuestions(List<Question> questions);

    public List<Question> getAllQuestions();

    public String deleteQuestion(int id);

    public Question updateQuestion(Question question);
}
