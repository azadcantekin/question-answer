package com.act.questionanswer.service.impl;

import com.act.questionanswer.model.Answer;
import com.act.questionanswer.repository.AnswerRepository;
import com.act.questionanswer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Optional<Answer> getAnswer(Integer id) {
        return answerRepository.findById(id);
    }

    @Override
    public Answer updateAnswer(Integer id, Answer answer) {
        return null;
    }

    @Override
    public List<Answer> getAllAnswerByQuestionId(Integer id) {
        return answerRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public List<Answer> getAllAnswerByUserId(Integer id) {
        return answerRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public void deleteAnswer(Integer id) {
        answerRepository.deleteById(id);
    }
}
