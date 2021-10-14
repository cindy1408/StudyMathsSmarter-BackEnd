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

            Question questionS11 = new Question(
                    Topics.SOLVING_EQUATION,
                    ByteConverter.imageToBytes("questionS11.png"),
                    1,
                    "a",
                    "https://justmaths.co.uk/wp-content/uploads/2015/12/Algebra-H-Forming-Solving-Equations-v1.pdf"
            );


            Question questionS21 = new Question(
                    Topics.SOLVING_EQUATION,
                    ByteConverter.imageToBytes("questionS21.png"),
                    2,
                    "a",
                    "https://justmaths.co.uk/wp-content/uploads/2015/12/Algebra-H-Forming-Solving-Equations-v1.pdf"
            );


            Question questionS31 = new Question(
                    Topics.SOLVING_EQUATION,
                    ByteConverter.imageToBytes("questionS31.png"),
                    3,
                    "d",
                    "https://justmaths.co.uk/wp-content/uploads/2015/12/Algebra-H-Forming-Solving-Equations-v1.pdf"
            );

            Question questionG11 = new Question(
                    Topics.GEOMETRY,
                    ByteConverter.imageToBytes("questionG11.png"),
                    1,
                    "b",
                    "https://justmaths.co.uk/wp-content/uploads/2015/12/Geometry-H-Similarity-Congruence-v2.pdf"
            );

            Question questionG21 = new Question(
                    Topics.GEOMETRY,
                    ByteConverter.imageToBytes("questionG21.png"),
                    2,
                    "c",
                    "https://justmaths.co.uk/wp-content/uploads/2015/12/Geometry-H-Similarity-Congruence-v2.pdf"
            );


            Question questionG31 = new Question(
                    Topics.GEOMETRY,
                    ByteConverter.imageToBytes("questionG31.png"),
                    3,
                    "a",
                    "https://justmaths.co.uk/wp-content/uploads/2015/12/Geometry-H-Similarity-Congruence-v2.pdf"
            );


            Question questionT11 = new Question(
                    Topics.TRIGONOMETRY,
                    ByteConverter.imageToBytes("questionT11.png"),
                    1,
                    "d",
                    "http://justmaths.co.uk/wp-content/uploads/2015/12/Geometry-H-Trigonometry-v1.pdf"
            );


            Question questionT21 = new Question(
                    Topics.TRIGONOMETRY,
                    ByteConverter.imageToBytes("questionT21.png"),
                    2,
                    "b",
                    "http://justmaths.co.uk/wp-content/uploads/2015/12/Geometry-H-Trigonometry-v1.pdf"
            );


            Question questionT31 = new Question(
                    Topics.TRIGONOMETRY,
                    ByteConverter.imageToBytes("questionT31.png"),
                    3,
                    "c",
                    "http://justmaths.co.uk/wp-content/uploads/2015/12/Geometry-H-Trigonometry-v1.pdf"
            );
            questionRepositoryPostgres.saveAll(
                    List.of(questionS11, questionS21, questionS31, questionG11, questionG21, questionG31,
                            questionT11, questionT21, questionT31));

        };
    }

}
