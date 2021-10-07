package com.StudyMathsSmarter.StudyMathsSmarter.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryPostgres extends JpaRepository<User, Integer> {
}
