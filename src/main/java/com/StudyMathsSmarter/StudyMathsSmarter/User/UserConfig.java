package com.StudyMathsSmarter.StudyMathsSmarter.User;

import com.StudyMathsSmarter.StudyMathsSmarter.security.AppUserRole;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLine(UserRepositoryPostgres userRepositoryPostgres){
        return args -> {

            User sample = new User(
                    "Cindy",
                    "Cheung",
                    "cindycheung1408@gmail.com",
                    UserService.passwordEncoder().encode("Cindy"),
                    AppUserRole.STUDENT
            );

            User yulin = new User(
                    "Yulin",
                    "Chen",
                    "yulin@email.com",
                    UserService.passwordEncoder().encode("admin"),
                    AppUserRole.ADMIN
            );

            userRepositoryPostgres.saveAll(
                    List.of(sample, yulin)
            );

            Faker faker = new Faker();

            for (int i=0; i < 20; i++){
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = String.format("%s.%s@brightnetwork.com", firstName, lastName);

                User user = new User(firstName, lastName, email, UserService.passwordEncoder().encode(firstName), (int) Math.random()*100, AppUserRole.STUDENT);
                userRepositoryPostgres.save(user);
            }

        };
    }

}
