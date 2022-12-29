package com.act.questionanswer.service;

import com.act.questionanswer.model.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    Answer addAnswer(Answer answer);
    Optional<Answer> getAnswer(Integer id);

    Answer updateAnswer(Integer id , Answer answer);
    List<Answer> getAllAnswerByQuestionId(Integer id);

    List<Answer> getAllAnswerByUserId(Integer id);

    void deleteAnswer(Integer id);
}
