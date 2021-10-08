package com.StudyMathsSmarter.StudyMathsSmarter.Quiz;

import com.StudyMathsSmarter.StudyMathsSmarter.Question.Question;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("start")
    public List<Question> getNewQuiz(){
        return quizService.getNewQuiz();
    }

    @PostMapping("start")
    public Quiz getScore(@RequestBody ObjectNode objectNode){
        String answerOne = objectNode.get("answerOne").asText();
        String answerTwo = objectNode.get("answerTwo").asText();
        String answerThree = objectNode.get("answerThree").asText();
        String answerFour = objectNode.get("answerFour").asText();
        String answerFive = objectNode.get("answerFive").asText();
        String answerSix = objectNode.get("answerSix").asText();
        List<String> answers = new ArrayList<>(List.of(answerOne, answerTwo, answerThree, answerFour, answerFive, answerSix));

        return quizService.getQuizResult(answers);
    }

    @PostMapping("{id}")
    public Quiz getScoreForUser(@PathVariable("id") int userId, @RequestBody ObjectNode objectNode){
        String answerOne = objectNode.get("answerOne").asText();
        String answerTwo = objectNode.get("answerTwo").asText();
        String answerThree = objectNode.get("answerThree").asText();
        String answerFour = objectNode.get("answerFour").asText();
        String answerFive = objectNode.get("answerFive").asText();
        String answerSix = objectNode.get("answerSix").asText();
        List<String> answers = new ArrayList<>(List.of(answerOne, answerTwo, answerThree, answerFour, answerFive, answerSix));

        return quizService.getQuizResultForUser(userId, answers);
    }

    @GetMapping("{id}")
    public List<Quiz> getAllQuizForUser(@PathVariable("id") int userId){
        return quizService.selectAllQuizForUser(userId);
    }
}
