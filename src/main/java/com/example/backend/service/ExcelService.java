package com.example.backend.service;

import com.example.backend.helper.ExcelHelper;
import com.example.backend.model.Question;
import com.example.backend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    QuestionRepository questionRepository;

    public void saveQuestionsToDatabase(MultipartFile file) {
        try {
            List<Question> questions = ExcelHelper.excelToQuestions(file.getInputStream());
            questionRepository.saveAll(questions);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}
