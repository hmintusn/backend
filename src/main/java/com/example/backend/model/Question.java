package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "questions")
public class Question {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer qid;
        private String title;
        private String option1;
        private String option2;
        private String option3;
        private String option4;

        @Column(name = "correct_answer")
        private Integer correctAnswer;

        private String explanation;

        public Question(String title, String option1, String option2, String option3, String option4, Integer correctAnswer, String explanation) {
            this.title = title;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.option4 = option4;
            this.correctAnswer = correctAnswer;
            this.explanation = explanation;
        }
}
