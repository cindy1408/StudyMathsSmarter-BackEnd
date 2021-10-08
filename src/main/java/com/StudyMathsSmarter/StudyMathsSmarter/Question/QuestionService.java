package com.StudyMathsSmarter.StudyMathsSmarter.Question;

import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
import com.StudyMathsSmarter.StudyMathsSmarter.utils.ByteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepositoryPostgres questionRepositoryPostgres;

    @Autowired
    public QuestionService(QuestionRepositoryPostgres questionRepositoryPostgres) {
        this.questionRepositoryPostgres = questionRepositoryPostgres;
    }

    //GET REQUEST
    public List<Question> getAllQuestions(){
        return questionRepositoryPostgres.findAll();
    }

    //GET REQUEST
    public Optional<Question> requestedQuestion(int questionId) {
        return questionRepositoryPostgres.findById(questionId);
    }

    //POST REQUEST
    public void addNewQuestion(Question newQuestion){
        questionRepositoryPostgres.save(newQuestion);
    }

    //PUT REQUEST
    //String columnToUpdate, String updateContent
    public void updateQuestion(int questionId,String columnToUpdate, String updateContent){
        questionRepositoryPostgres.findById(questionId)
                .ifPresentOrElse(selectedQuestion -> {
                    switch (columnToUpdate) {
                        case "topic" -> {
                            Topics updateContentConverted = null;
                            if(Objects.equals(updateContent, "solving_equations")){
                                updateContentConverted = Topics.SOLVING_EQUATION;
                            } else if (Objects.equals(updateContent, "geometry")){
                                updateContentConverted = Topics.GEOMETRY;
                            } else if (Objects.equals(updateContent, "trigonometry")){
                                updateContentConverted = Topics.TRIGONOMETRY;
                            }
                            selectedQuestion.setTopic(updateContentConverted);
                            questionRepositoryPostgres.save(selectedQuestion);
                        }

                        case "question_image" -> {
                               //TODO: upload image from api?
                            try {
                                selectedQuestion.setQuestionImage(ByteConverter.imageToBytes(updateContent));
                            } catch (IOException e) {
                                e.printStackTrace();
                            };

                            questionRepositoryPostgres.save(selectedQuestion);
                        }
                        case "answer" -> {
                            selectedQuestion.setAnswer(updateContent);
                            questionRepositoryPostgres.save(selectedQuestion);
                        }
                        case "level" -> {
                            selectedQuestion.setLevel(Integer.parseInt(updateContent));
                            questionRepositoryPostgres.save(selectedQuestion);
                        }
                        case "resource" -> {
                            selectedQuestion.setResource(updateContent);
                            questionRepositoryPostgres.save(selectedQuestion);
                        }
                    }
                }, () -> System.out.println("Question id was not found!"));
    }
    // DELETE REQUEST
    public void deleteQuestion(int questionId){
        questionRepositoryPostgres.findById(questionId)
                .ifPresentOrElse(questionRepositoryPostgres::delete, () -> {
                    System.out.println("No question associated to this question Id");
                });
    }
}
