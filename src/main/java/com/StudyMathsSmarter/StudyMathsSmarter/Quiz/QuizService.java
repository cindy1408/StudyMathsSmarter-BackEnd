package com.StudyMathsSmarter.StudyMathsSmarter.Quiz;

import com.StudyMathsSmarter.StudyMathsSmarter.Question.Question;
import com.StudyMathsSmarter.StudyMathsSmarter.Question.QuestionRepositoryPostgres;
import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
import com.StudyMathsSmarter.StudyMathsSmarter.User.User;
import com.StudyMathsSmarter.StudyMathsSmarter.User.UserRepositoryPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

@Service
public class QuizService {
    private final QuizRepositoryPostgres quizRepositoryPostgres;
    private final UserRepositoryPostgres userRepositoryPostgres;
    private final QuestionRepositoryPostgres questionRepositoryPostgres;
    private List<Question> quiz;

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

    public List<Question> getNewQuiz(){
        List<Question> questionOnes = questionRepositoryPostgres.findAllTopics(Topics.SOLVING_EQUATION);
        List<Question> questionTwos = questionRepositoryPostgres.findAllTopics(Topics.GEOMETRY);
        List<Question> questionThrees = questionRepositoryPostgres.findAllTopics(Topics.TRIGONOMETRY);

        Integer[] randIndexOnes = randomInt(2, questionOnes.size());
        Integer[] randIndexTwos = randomInt(2, questionTwos.size());
        Integer[] randIndexThrees = randomInt(2, questionThrees.size());
        quiz = new ArrayList<>(List.of(
                questionOnes.get(randIndexOnes[0]),
                questionOnes.get(randIndexOnes[1]),
                questionTwos.get(randIndexTwos[0]),
                questionTwos.get(randIndexTwos[1]),
                questionThrees.get(randIndexThrees[0]),
                questionThrees.get(randIndexThrees[1])
        ));

        return quiz;
    }

    //Show result for unregistered user
    public Quiz getQuizResult(List<String> answers){
        int score = 0;
        double fullScore = 0;

        int[] scores = new int[6];
        for (int i = 0; i < answers.size(); i++){
            if (answers.get(i).equals(quiz.get(i).getAnswer())){
                scores[i] = quiz.get(i).getLevel();
                score = score + quiz.get(i).getLevel();
            }
            fullScore = fullScore + quiz.get(i).getLevel();
        }

        double finalScore = score/fullScore*100;

        Quiz quiz = new Quiz(0, scores[0], scores[1], scores[2], scores[3], scores[4], scores[5], LocalDate.now(), finalScore);
        return quiz;
    }

    //Show result for registered user and save to database
    public Quiz getQuizResultForUser(int userId, List<String> answers){
        int score = 0;
        double fullScore = 0;
        User user = userRepositoryPostgres.findById(userId).get();

        int[] scores = new int[6];
        for (int i = 0; i < answers.size(); i++){
            if (answers.get(i).equals(quiz.get(i).getAnswer())){
                scores[i] = quiz.get(i).getLevel();
                score = score + quiz.get(i).getLevel();
            }
            fullScore = fullScore + quiz.get(i).getLevel();
        }

        double finalScore = score/fullScore*100;

        Quiz quiz = new Quiz(userId, scores[0], scores[1], scores[2], scores[3], scores[4], scores[5], LocalDate.now(), finalScore);

        quizRepositoryPostgres.save(quiz);

        if (finalScore > user.getScore()){
            user.setScore(finalScore);
            userRepositoryPostgres.save(user);
        }

        return quiz;
    }

    public List<Quiz> selectAllQuizForUser(int userId){
        return quizRepositoryPostgres.selectAllQuizForUser(userId);
    }


    public void updateQuiz(int quizId, String columnToUpdate, int contentToUpdate){
        quizRepositoryPostgres.findById(quizId)
                .ifPresentOrElse(selectedQuiz -> {
                    switch (columnToUpdate) {
                        case "question_g1_score" -> {
                            selectedQuiz.setQuestionG1Score(contentToUpdate);
                            quizRepositoryPostgres.save(selectedQuiz);
                        }
                        case "question_g2_score" -> {
                            selectedQuiz.setQuestionG2Score(contentToUpdate);
                            quizRepositoryPostgres.save(selectedQuiz);
                        }
                        case "question_s1_score" -> {
                            selectedQuiz.setQuestionS1Score(contentToUpdate);
                            quizRepositoryPostgres.save(selectedQuiz);
                        }
                        case "question_s2_score" -> {
                            selectedQuiz.setQuestionS2Score(contentToUpdate);
                            quizRepositoryPostgres.save(selectedQuiz);
                        }
                        case "question_t1_score" -> {
                            selectedQuiz.setQuestionT1Score(contentToUpdate);
                            quizRepositoryPostgres.save(selectedQuiz);
                        }
                        case "question_t2_score" -> {
                            selectedQuiz.setQuestionT2Score(contentToUpdate);
                            quizRepositoryPostgres.save(selectedQuiz);
                        }
                        case "user_id" -> {
                            selectedQuiz.setUserId(contentToUpdate);
                            quizRepositoryPostgres.save(selectedQuiz);
                        }
                    }
                }, () -> System.out.println("Cannot find your quiz id"));
    }

    public void addLocalDateToQuiz(int quizId){
        quizRepositoryPostgres.findById(quizId)
                .ifPresentOrElse(selectedQuiz -> {
                    selectedQuiz.setTimeStamp(LocalDate.now());
                    quizRepositoryPostgres.save(selectedQuiz);
                }, () -> System.out.println("Cannot find your quiz id"));

    private Integer[] randomInt(int n, int k){
        final Set<Integer> picked = new HashSet<>();
        Random random = new Random();
        while (picked.size() < n){
            picked.add(random.nextInt(k));
        }

        Integer[] result = picked.toArray(new Integer[n]);
        return result;
    }
}
