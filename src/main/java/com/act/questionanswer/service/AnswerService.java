package com.act.questionanswer.service;


import com.act.questionanswer.model.dto.AnswerDto;

import java.util.List;

public interface AnswerService {
    AnswerDto addAnswer(AnswerDto answerDto);
    AnswerDto getAnswer(Integer id);

    AnswerDto updateAnswer(Integer id , AnswerDto answerDto);
    List<AnswerDto> getAllAnswerByQuestionId(Integer id);

    List<AnswerDto> getAllAnswerByUserId(Integer id);

    void deleteAnswer(Integer id);
}
