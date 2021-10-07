//package com.StudyMathsSmarter.StudyMathsSmarter.User;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class UserConfig {
//    @Bean
//    CommandLineRunner commandLine(UserRepositoryPostgres userRepositoryPostgres){
//        return args -> {
//            User sample = new User(
//                    "Cindy",
//                    "Cheung",
//                    "cindycheung1408@gmail.com"
//            );
//            userRepositoryPostgres.saveAll(
//                    List.of(sample)
//            );
//        };
//    }
//
//}
