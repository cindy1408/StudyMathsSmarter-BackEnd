package com.StudyMathsSmarter.StudyMathsSmarter.Question;

import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
import com.StudyMathsSmarter.StudyMathsSmarter.utils.ByteConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuestionRepositoryPostgres questionRepositoryPostgres){
        return args -> {
            // add your questions! :D
            Question sample = new Question(
                    Topics.SOLVING_EQUATION,
                    ByteConverter.imageToBytes("solve_eq1.png"),
                    1,
                    "answers",
                    "resource link"
            );


            questionRepositoryPostgres.save(sample);


        };
    }

}
