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

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> saveAllQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public String deleteQuestion(int qid){
        questionRepository.deleteById(qid);
        return "Question removed !! " + qid;
    }

    public Question updateQuestion(Question question){
        Question existingQuestion = questionRepository.findById(question.getQid()).orElse(null);
        existingQuestion.setTitle(question.getTitle());
        existingQuestion.setOption1(question.getOption1());
        existingQuestion.setOption2(question.getOption2());
        existingQuestion.setOption3(question.getOption3());
        existingQuestion.setOption4(question.getOption4());
        existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
        existingQuestion.setExplanation(question.getExplanation());
        return questionRepository.save(existingQuestion);
    }
}
