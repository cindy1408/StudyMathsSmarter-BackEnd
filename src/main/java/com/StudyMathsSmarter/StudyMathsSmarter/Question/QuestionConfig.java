package com.StudyMathsSmarter.StudyMathsSmarter.Question;

import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuestionRepositoryPostgres questionRepositoryPostgres){
        return args -> {
            // add your questions
            //SOLVING EQUATIONS
            // QUESTION NAME = 'question' +  topic initial + level + question number
            Question questionS11 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    1,
                    "answer",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionS11));

            Question questionS21 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    2,
                    "answer",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionS21));

            Question questionS31 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    3,
                    "answers",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionS31));


            Question questionG11 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    1,
                    "answers",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionG11));

            Question questionG21 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    2,
                    "answers",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionG21));

            Question questionG31 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    3,
                    "answers",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionG31));

            Question questionT11 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    1,
                    "answers",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionT11));

            Question questionT21 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    2,
                    "answers",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionT21));

            Question questionT31 = new Question(
                    Topics.SOLVING_EQUATION,
                    "url",
                    3,
                    "answers",
                    "resource link"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionT31));
        };
    }

}
