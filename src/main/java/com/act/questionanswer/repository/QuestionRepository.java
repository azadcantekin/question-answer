package com.act.questionanswer.repository;

import com.act.questionanswer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question , Integer> {
    List<Question> findAllQuestionsByUserId(Integer id);
}
