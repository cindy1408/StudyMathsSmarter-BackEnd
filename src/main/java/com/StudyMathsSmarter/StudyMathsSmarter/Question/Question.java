package com.StudyMathsSmarter.StudyMathsSmarter.Question;
import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Question")
@Table(name = "questions")


public class Question {
    @Id
    @SequenceGenerator(name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "question_sequence"
    )
    @Column(name = "id", updatable = false)
    private int id;
    @Column(name = "topic", nullable = false)
    @Enumerated(EnumType.STRING)
    private Topics topic;
    @Column(name = "question_image", nullable = false)
    private byte[] questionImage;
    @Column(name = "level", nullable = false)
    private int level;
    @Column(name = "answer", nullable = false)
    private String answer;
    @Column(name = "resource", nullable = false)
    private String resource;

    public Question(@JsonProperty("topic") Topics topic,
                    @JsonProperty("questionImage") byte[] questionImage,
                    @JsonProperty("level") int level,
                    @JsonProperty("answer") String answer,
                    @JsonProperty("resource") String resource) {
        this.topic = topic;
        this.questionImage = questionImage;
        this.level = level;
        this.answer = answer;
        this.resource = resource;
    }

    public Question() {
    }

    public int getId(){ return id; }

    public void setId(int id){ this.id = id; }

    public Topics getTopic() {
        return topic;
    }

    public void setTopic(Topics topic) {
        this.topic = topic;
    }

    public byte[] getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(byte[] questionImage) {
        this.questionImage = Question.this.questionImage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return level == question.level && Objects.equals(id, question.id) && Objects.equals(topic, question.topic) && Objects.equals(questionImage, question.questionImage) && Objects.equals(answer, question.answer) && Objects.equals(resource, question.resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, questionImage, level, answer, resource);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", questionImage='" + questionImage + '\'' +
                ", level=" + level +
                ", answer='" + answer + '\'' +
                ", resource='" + resource + '\'' +
                '}';
    }

}
