package com.act.questionanswer.service.impl;

import com.act.questionanswer.model.Question;
import com.act.questionanswer.repository.QuestionRepository;
import com.act.questionanswer.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Optional<Question> getQuestion(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllQuestionByUserId(Integer id) {
        return questionRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public Question updateQuestion(Integer id, Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(Integer id) {
    questionRepository.deleteById(id);
    }
}
