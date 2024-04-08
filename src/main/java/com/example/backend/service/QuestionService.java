package com.example.backend.service;

import com.example.backend.model.Question;

import java.util.List;

public interface QuestionService {
    public List<Question> getAllQuestions();

    public Question getQuestionById(int id);

    public Question saveQuestion(Question question);

    public List<Question> saveAllQuestions(List<Question> questions);

    public String deleteQuestion(int id);

    public String deleteAllQuestions();

    public Question updateQuestion(Question question);
}
