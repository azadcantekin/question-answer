package com.act.questionanswer.repository;

import com.act.questionanswer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
