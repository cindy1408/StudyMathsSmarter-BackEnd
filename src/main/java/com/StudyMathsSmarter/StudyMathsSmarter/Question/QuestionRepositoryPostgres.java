package com.StudyMathsSmarter.StudyMathsSmarter.Question;

import com.StudyMathsSmarter.StudyMathsSmarter.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepositoryPostgres extends JpaRepository<Question, Integer> {
    @Query("SELECT q FROM Question q WHERE q.topic = ?1 ")
    List<Question> findAllTopics(Topics topic);

}
