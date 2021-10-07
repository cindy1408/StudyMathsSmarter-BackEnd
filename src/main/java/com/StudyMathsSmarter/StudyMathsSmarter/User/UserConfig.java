package com.StudyMathsSmarter.StudyMathsSmarter.User;

import com.StudyMathsSmarter.StudyMathsSmarter.Question.Question;
import com.StudyMathsSmarter.StudyMathsSmarter.Question.QuestionRepositoryPostgres;
import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLine(UserRepositoryPostgres userRepositoryPostgres){
        return args -> {
            // add your questions! :D
            User sample = new User(
                    "Cindy",
                    "Cheung",
                    "cindycheung1408@gmail.com"
            );
            userRepositoryPostgres.saveAll(
                    List.of(sample)
            );
        };
    }

}
