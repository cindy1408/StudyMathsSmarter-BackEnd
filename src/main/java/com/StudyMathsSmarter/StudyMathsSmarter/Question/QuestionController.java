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

    @GetMapping("{questionId}")
    public Optional<Question> requestedQuestion(@PathVariable int questionId){return questionService.requestedQuestion(questionId);}

    @PostMapping
    public void insertNewQuestion(@RequestBody Question newQuestion){questionService.addNewQuestion(newQuestion);}

    @PutMapping("{questionId}/{columnToUpdate}/{contentToUpdate}")
    public void updateQuestion(@PathVariable int questionId, @PathVariable String columnToUpdate, @PathVariable String contentToUpdate){
        questionService.updateQuestion(questionId, columnToUpdate, contentToUpdate);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable int questionId){
        questionService.deleteQuestion(questionId);
    }
}
