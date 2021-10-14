package com.StudyMathsSmarter.StudyMathsSmarter.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserRepositoryPostgres extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
    @Query("SELECT u FROM Users u ORDER BY u.score DESC")
    List<User> findTopTen();
}
