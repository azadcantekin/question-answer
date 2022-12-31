package com.act.questionanswer.repository;

import com.act.questionanswer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question , Integer> {
}
