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
    //get all questions
    public ResponseEntity<?> getAllQuestions(){
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    //get question by id
    @GetMapping("/{qid}")
    public ResponseEntity<?> getQuestionById(@PathVariable int qid){
        return ResponseEntity.ok(questionService.getQuestionById(qid));
    }
    //add new question
    @PostMapping("/save")
    public ResponseEntity<?> saveQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.saveQuestion(question));
    }

    //add list of questions
    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAllQuestions(@RequestBody List<Question> questions){
        return ResponseEntity.ok(questionService.saveAllQuestions(questions));
    }

    //update question
    @PutMapping("/update")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    //delete question by id
    @DeleteMapping("/delete/{qid}")
    public ResponseEntity<?> deleteQuestion(@PathVariable int qid){
        return ResponseEntity.ok(questionService.deleteQuestion(qid));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllQuestions(){
        return ResponseEntity.ok(questionService.deleteAllQuestions());
    }

    //upload questions from Excel file
    @PostMapping(
            path ="/excel/upload",
            consumes = {"multipart/form-data"})
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
}