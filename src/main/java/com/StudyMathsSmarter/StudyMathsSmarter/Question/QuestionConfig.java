//package com.StudyMathsSmarter.StudyMathsSmarter.Question;
//
//import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class QuestionConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(QuestionRepositoryPostgres questionRepositoryPostgres){
//        return args -> {
//            // add your questions! :D
//            Question sample = new Question(
//                    Topics.SOLVING_EQUATION,
//                    "question_urls",
//                    3,
//                    "answers",
//                    "resource link"
//            );
//            questionRepositoryPostgres.saveAll(
//                    List.of(sample)
//            );
//        };
//    }
//}
