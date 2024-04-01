package com.example.backend.controller;

import com.example.backend.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.QuestionService;
import java.util.List;

@RestController
@RequestMapping("/question")
public class questionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

//  add new question
    @PostMapping("/save")
    public Question saveQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }
}
