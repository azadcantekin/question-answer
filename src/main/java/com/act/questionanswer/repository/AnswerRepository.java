package com.act.questionanswer.repository;

import com.act.questionanswer.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer , Integer> {
}
