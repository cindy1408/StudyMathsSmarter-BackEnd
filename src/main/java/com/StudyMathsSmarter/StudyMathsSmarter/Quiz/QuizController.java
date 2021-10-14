package com.StudyMathsSmarter.StudyMathsSmarter.Quiz;

import com.StudyMathsSmarter.StudyMathsSmarter.Question.Question;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("study_maths_smarter/quiz")
@RestController
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Quiz> quizFullList(){
        return quizService.getAllQuiz();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void insertNewQuiz(Quiz newQuiz){
        quizService.addNewQuiz(newQuiz);
    }

    @GetMapping("start")
    public List<Question> getNewQuiz(){
        return quizService.getNewQuiz();
    }

    @PostMapping("{id}")
    public Quiz getScoreForRegisteredUser(@PathVariable(value = "id") int userId, @RequestBody ObjectNode objectNode){
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_STUDENT')")
    public List<Quiz> getAllQuizForUser(@PathVariable("id") int userId){
        return quizService.selectAllQuizForUser(userId);
    }

    @PutMapping("{quizId}/{columnToUpdate}/{contentToUpdate}")
    public void updateQuiz(@PathVariable int quizId, @PathVariable String columnToUpdate, @PathVariable int contentToUpdate){
        quizService.updateQuiz(quizId, columnToUpdate, contentToUpdate);
    }

    @PutMapping("{quizId}")
    public void addLocalDateToQuiz(@PathVariable int quizId){
        quizService.addLocalDateToQuiz(quizId);
    }
}
