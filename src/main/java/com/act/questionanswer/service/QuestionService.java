package com.act.questionanswer.service;


import com.act.questionanswer.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
   Question addQuestion(Question question);
   Optional<Question> getQuestion(Integer id);
   List<Question> getAllQuestion();
   List<Question> getAllQuestionByUserId(Integer id);
   Question updateQuestion(Integer id , Question question);
   void deleteQuestion(Integer id);
}
