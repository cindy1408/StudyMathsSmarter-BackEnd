package com.StudyMathsSmarter.StudyMathsSmarter.Quiz;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name="quiz")
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
    @Column(name="question_id")
    private int questionId;
    @Column(name="time_stamp")
    private LocalDate timeStamp;
    @Column(name="result")
    private int result;

    public Quiz(@JsonProperty("user_id") int userId,
                @JsonProperty("question_id") int questionId,
                @JsonProperty("time_stamp") LocalDate timeStamp,
                @JsonProperty("result") int result) {
        this.userId = userId;
        this.questionId = questionId;
        this.timeStamp = timeStamp;
        this.result = result;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return id == quiz.id && userId == quiz.userId && questionId == quiz.questionId && result == quiz.result && Objects.equals(timeStamp, quiz.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, questionId, timeStamp, result);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", userId=" + userId +
                ", questionId=" + questionId +
                ", timeStamp=" + timeStamp +
                ", result=" + result +
                '}';
    }
}
