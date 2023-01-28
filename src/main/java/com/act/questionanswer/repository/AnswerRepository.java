package com.act.questionanswer.repository;

import com.act.questionanswer.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer , Integer> {
    List<Answer> findAllAnswerByQuestionId(Integer id);
    List<Answer> findAllAnswerByUserId(Integer id);
}
