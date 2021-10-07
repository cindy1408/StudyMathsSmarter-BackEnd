package com.StudyMathsSmarter.StudyMathsSmarter.Question;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("study_maths_smarter/question")
@RestController
public class QuestionController {
    public final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping
    public List<Question> listAllQuestions(){return questionService.getAllQuestions();}

    @GetMapping("/question")
    public Optional<Question> requestedQuestion(int questionId){return questionService.requestedQuestion(questionId);}

    @PostMapping
    public void insertNewQuestion(Question newQuestion){questionService.addNewQuestion(newQuestion);}

    @PutMapping("/{questionId}/{columnToUpdate}/{contentToUpdate}")
    public void updateQuestion(int questionId, String columnToUpdate, String contentToUpdate){
        questionService.updateQuestion(questionId, columnToUpdate, contentToUpdate);
    }
}
