package com.StudyMathsSmarter.StudyMathsSmarter.Quiz;

import com.StudyMathsSmarter.StudyMathsSmarter.Question.QuestionRepositoryPostgres;
import com.StudyMathsSmarter.StudyMathsSmarter.User.UserRepositoryPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepositoryPostgres quizRepositoryPostgres;
    private final UserRepositoryPostgres userRepositoryPostgres;
    private final QuestionRepositoryPostgres questionRepositoryPostgres;
    @Autowired
    public QuizService(QuizRepositoryPostgres quizRepositoryPostgres, UserRepositoryPostgres userRepositoryPostgres, QuestionRepositoryPostgres questionRepositoryPostgres) {
        this.quizRepositoryPostgres = quizRepositoryPostgres;
        this.userRepositoryPostgres = userRepositoryPostgres;
        this.questionRepositoryPostgres = questionRepositoryPostgres;
    }

    //GET REQUEST
    public List<Quiz> getAllQuiz(){
        return quizRepositoryPostgres.findAll();
    }

    //POST REQUEST
    public void addNewQuiz(Quiz newQuiz){
        quizRepositoryPostgres.save(newQuiz);
    }

}
