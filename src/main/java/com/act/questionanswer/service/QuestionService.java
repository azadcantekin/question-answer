package com.act.questionanswer.service;


import com.act.questionanswer.model.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
   QuestionDto addQuestion(QuestionDto questionDto);
   QuestionDto getQuestion(Integer id);
   List<QuestionDto> getAllQuestion();
   List<QuestionDto> getAllQuestionByUserId(Integer id);
   QuestionDto updateQuestion(Integer id , QuestionDto questionDto);
   void deleteQuestion(Integer id);
}
