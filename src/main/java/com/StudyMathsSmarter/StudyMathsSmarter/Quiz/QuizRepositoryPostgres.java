package com.StudyMathsSmarter.StudyMathsSmarter.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepositoryPostgres extends JpaRepository<Quiz, Integer> {
    @Query("SELECT q FROM Quiz q WHERE q.userId = ?1")
    List<Quiz> selectAllQuizForUser(int userId);
}
