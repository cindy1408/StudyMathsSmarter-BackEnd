package com.StudyMathsSmarter.StudyMathsSmarter.User;

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
                    UserService.passwordEncoder().encode("Cindy")
            );

            userRepositoryPostgres.saveAll(
                    List.of(sample)
            );

            Faker faker = new Faker();

            for (int i=0; i < 20; i++){
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = String.format("%s.%s@brightnetwork.com", firstName, lastName);

                User user = new User(firstName, lastName, email, UserService.passwordEncoder().encode(firstName), Math.random()*100);
                userRepositoryPostgres.save(user);
            }

        };
    }

}
