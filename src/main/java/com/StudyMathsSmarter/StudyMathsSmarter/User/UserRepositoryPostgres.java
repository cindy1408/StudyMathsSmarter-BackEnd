package com.StudyMathsSmarter.StudyMathsSmarter.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryPostgres extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
}
