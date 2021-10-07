package com.StudyMathsSmarter.StudyMathsSmarter.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("study_maths_smarter/quiz")
@RestController
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public List<Quiz> quizFullList(){
        return quizService.getAllQuiz();
    }

    @PostMapping
    public void insertNewQuiz(Quiz newQuiz){
        quizService.addNewQuiz(newQuiz);
    }


}
