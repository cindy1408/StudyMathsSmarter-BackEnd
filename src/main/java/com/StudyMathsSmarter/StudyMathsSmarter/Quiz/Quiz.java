package com.StudyMathsSmarter.StudyMathsSmarter.Quiz;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name="Quiz")
@Table(name="quiz")
public class Quiz {
    @Id
    @SequenceGenerator( name="quiz_sequence",
                        sequenceName = "quiz_sequence",
                        allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "quiz_sequence"
    )
    @Column(name="id", updatable = false)
    private int id;
    @Column(name="user_id")
    private int userId;
    @Column(name="question_s1_score")
    private int questionS1Score;
    @Column(name="question_s2_score")
    private int questionS2Score;
    @Column(name="question_g1_score")
    private int questionG1Score;
    @Column(name="question_g2_score")
    private int questionG2Score;
    @Column(name="question_t1_score")
    private int questionT1Score;
    @Column(name="question_t2_score")
    private int questionT2Score;
    @Column(name="time_stamp")
    private LocalDate timeStamp;
    @Column(name="result")
    private double result;

    public Quiz(    @JsonProperty("user_id") int userId,
                    @JsonProperty("question_s1_score") int questionS1Score,
                    @JsonProperty("question_s2_score") int questionS2Score,
                    @JsonProperty("question_g1_score") int questionG1Score,
                    @JsonProperty("question_g2_score") int questionG2Score,
                    @JsonProperty("question_t1_score") int questionT1Score,
                    @JsonProperty("question_t2_score") int questionT2Score,
                    @JsonProperty("time_stamp") LocalDate timeStamp,
                    @JsonProperty("result") double result) {
        this.userId = userId;
        this.questionS1Score = questionS1Score;
        this.questionS2Score = questionS2Score;
        this.questionG1Score = questionG1Score;
        this.questionG2Score = questionG2Score;
        this.questionT1Score = questionT1Score;
        this.questionT2Score = questionT2Score;
        this.timeStamp = timeStamp;
        this.result = result;
    }

    public Quiz() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionS1Score() {
        return questionS1Score;
    }

    public void setQuestionS1Score(int questionS1Score) {
        this.questionS1Score = questionS1Score;
    }

    public int getQuestionS2Score() {
        return questionS2Score;
    }

    public void setQuestionS2Score(int questionS2Score) {
        this.questionS2Score = questionS2Score;
    }

    public int getQuestionG1Score() {
        return questionG1Score;
    }

    public void setQuestionG1Score(int questionG1Score) {
        this.questionG1Score = questionG1Score;
    }

    public int getQuestionG2Score() {
        return questionG2Score;
    }

    public void setQuestionG2Score(int questionG2Score) {
        this.questionG2Score = questionG2Score;
    }

    public int getQuestionT1Score() {
        return questionT1Score;
    }

    public void setQuestionT1Score(int questionT1Score) {
        this.questionT1Score = questionT1Score;
    }

    public int getQuestionT2Score() {
        return questionT2Score;
    }

    public void setQuestionT2Score(int questionT2Score) {
        this.questionT2Score = questionT2Score;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return id == quiz.id && userId == quiz.userId && questionS1Score == quiz.questionS1Score && questionS2Score == quiz.questionS2Score && questionG1Score == quiz.questionG1Score && questionG2Score == quiz.questionG2Score && questionT1Score == quiz.questionT1Score && questionT2Score == quiz.questionT2Score && Double.compare(quiz.result, result) == 0 && Objects.equals(timeStamp, quiz.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, questionS1Score, questionS2Score, questionG1Score, questionG2Score, questionT1Score, questionT2Score, timeStamp, result);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", userId=" + userId +
                ", questionS1Score=" + questionS1Score +
                ", questionS2Score=" + questionS2Score +
                ", questionG1Score=" + questionG1Score +
                ", questionG2Score=" + questionG2Score +
                ", questionT1Score=" + questionT1Score +
                ", questionT2Score=" + questionT2Score +
                ", timeStamp=" + timeStamp +
                ", result=" + result +
                '}';
    }
}
