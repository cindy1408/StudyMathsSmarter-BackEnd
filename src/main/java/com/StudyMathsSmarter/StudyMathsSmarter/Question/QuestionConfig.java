//package com.StudyMathsSmarter.StudyMathsSmarter.Question;
//
//import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
//import com.StudyMathsSmarter.StudyMathsSmarter.utils.ByteConverter;
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
//            // add your questions
//            //SOLVING EQUATIONS
//            // QUESTION NAME = 'question' +  topic initial + level + question number
//            Question questionS11 = new Question(
//                    Topics.SOLVING_EQUATION,
//                    ByteConverter.imageToBytes("questionS11.png"),
//                    1,
//                    "a",
//                    "https://www.mathsgenie.co.uk/simultaneous-quadratic.html"
//            );
//
//
//            Question questionS21 = new Question(
//                    Topics.SOLVING_EQUATION,
//                    ByteConverter.imageToBytes("questionS21.png"),
//                    2,
//                    "a",
//                    "https://www.mathsgenie.co.uk/simultaneous-quadratic.html"
//            );
//
//
//            Question questionS31 = new Question(
//                    Topics.SOLVING_EQUATION,
//                    ByteConverter.imageToBytes("questionS31.png"),
//                    3,
//                    "d",
//                    "https://www.mathsgenie.co.uk/simultaneous-quadratic.html"
//            );
//
//            Question questionG11 = new Question(
//                    Topics.GEOMETRY,
//                    ByteConverter.imageToBytes("questionG11.png"),
//                    1,
//                    "b",
//                    "https://www.mathsgenie.co.uk/circles.html"
//            );
//
//            Question questionG21 = new Question(
//                    Topics.GEOMETRY,
//                    ByteConverter.imageToBytes("questionG21.png"),
//                    2,
//                    "c",
//                    "https://www.mathsgenie.co.uk/circles.html"
//            );
//
//
//            Question questionG31 = new Question(
//                    Topics.GEOMETRY,
//                    ByteConverter.imageToBytes("questionG31.png"),
//                    3,
//                    "a",
//                    "https://www.mathsgenie.co.uk/sectors-and-arcs.html"
//            );
//
//
//            Question questionT11 = new Question(
//                    Topics.TRIGONOMETRY,
//                    ByteConverter.imageToBytes("questionT11.png"),
//                    1,
//                    "d",
//                    "https://www.mathsgenie.co.uk/sohcahtoa.html"
//            );
//
//
//            Question questionT21 = new Question(
//                    Topics.TRIGONOMETRY,
//                    ByteConverter.imageToBytes("questionT21.png"),
//                    2,
//                    "b",
//                    "https://www.mathsgenie.co.uk/sohcahtoa.html"
//            );
//
//
//            Question questionT31 = new Question(
//                    Topics.TRIGONOMETRY,
//                    ByteConverter.imageToBytes("questionT31.png"),
//                    3,
//                    "c",
//                    "https://www.mathsgenie.co.uk/sine-rule.html"
//            );
//            questionRepositoryPostgres.saveAll(
//                    List.of(questionS11, questionS21, questionS31, questionG11, questionG21, questionG31,
//                            questionT11, questionT21, questionT31));
//
//        };
//    }
//
//}
