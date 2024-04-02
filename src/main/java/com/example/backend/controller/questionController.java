package com.example.backend.controller;

import com.example.backend.helper.ExcelHelper;
import com.example.backend.model.Question;
import com.example.backend.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.QuestionService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/question")
public class questionController {
    @Autowired
    QuestionService questionService;

    @Autowired
    ExcelService excelService;

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //add new question
    @PostMapping("/save")
    public Question saveQuestion(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    //add list of questions
    @PostMapping("/saveAll")
    public List<Question> saveAllQuestions(@RequestBody List<Question> questions){
        return questionService.saveAllQuestions(questions);
    }

    //upload questions from excel file
    @PostMapping("/excel/upload")
    public ResponseEntity<?> uploadQuestionsData(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                excelService.saveQuestionsToDatabase(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(200).body(message);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(500).body(message);
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(400).body(message);
    }

    //update question
    @PutMapping("/update")
    public Question updateQuestionPut(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    //delete question by id
    @DeleteMapping("/delete/{qid}")
    public String deleteQuestion(@PathVariable int qid){
        return questionService.deleteQuestion(qid);
    }
}
