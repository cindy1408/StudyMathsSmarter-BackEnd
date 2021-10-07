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
                    "image url",
                    1,
                    "a",
                    "https://www.mathsgenie.co.uk/simultaneous-quadratic.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionS11));

            Question questionS21 = new Question(
                    Topics.SOLVING_EQUATION,
                    "image url",
                    2,
                    "a",
                    "https://www.mathsgenie.co.uk/simultaneous-quadratic.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionS21));

            Question questionS31 = new Question(
                    Topics.SOLVING_EQUATION,
                    "image url",
                    3,
                    "d",
                    "https://www.mathsgenie.co.uk/simultaneous-quadratic.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionS31));


            Question questionG11 = new Question(
                    Topics.SOLVING_EQUATION,
                    "image url",
                    1,
                    "b",
                    "https://www.mathsgenie.co.uk/circles.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionG11));

            Question questionG21 = new Question(
                    Topics.SOLVING_EQUATION,
                    "image url",
                    2,
                    "c",
                    "https://www.mathsgenie.co.uk/circles.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionG21));

            Question questionG31 = new Question(
                    Topics.SOLVING_EQUATION,
                    "image url",
                    3,
                    "a",
                    "https://www.mathsgenie.co.uk/sectors-and-arcs.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionG31));

            Question questionT11 = new Question(
                    Topics.SOLVING_EQUATION,
                    "image url",
                    1,
                    "d",
                    "https://www.mathsgenie.co.uk/sohcahtoa.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionT11));

            Question questionT21 = new Question(
                    Topics.SOLVING_EQUATION,
                    "image url",
                    2,
                    "b",
                    "https://www.mathsgenie.co.uk/sohcahtoa.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionT21));

            Question questionT31 = new Question(
                    Topics.SOLVING_EQUATION,
                    "image url",
                    3,
                    "c",
                    "https://www.mathsgenie.co.uk/sine-rule.html"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionT31));
        };
    }

}
