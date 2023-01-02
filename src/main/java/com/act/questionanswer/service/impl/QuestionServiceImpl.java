package com.act.questionanswer.service.impl;

import com.act.questionanswer.model.Question;
import com.act.questionanswer.model.dto.QuestionDto;
import com.act.questionanswer.repository.QuestionRepository;
import com.act.questionanswer.service.QuestionService;
import com.act.questionanswer.utilities.mapper.ModelConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelConverterService converterService;

    @Override
    public QuestionDto addQuestion(QuestionDto questionDto) {
            questionRepository.save(converterService.convertToType(questionDto, Question.class));
            return questionDto;
    }

    @Override
    public QuestionDto getQuestion(Integer id) {
        Optional<Question> question = questionRepository.findById(id);
        return converterService.convertToType(question, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAllQuestion() {
        return Collections.singletonList(converterService.convertToType(questionRepository.findAll(), QuestionDto.class));
    }

    @Override
    public List<QuestionDto> getAllQuestionByUserId(Integer id) {
        return converterService.mapList(questionRepository.findAllQuestionsByUserId(id), QuestionDto.class);
    }

    @Override
    public QuestionDto updateQuestion(Integer id, QuestionDto updatedQuestionDto) {
        return null;
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }
}
