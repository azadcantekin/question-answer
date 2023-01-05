package com.act.questionanswer.service.impl;

import com.act.questionanswer.exception.ResourceNotFoundException;
import com.act.questionanswer.model.Question;
import com.act.questionanswer.model.dto.QuestionDto;
import com.act.questionanswer.repository.QuestionRepository;
import com.act.questionanswer.service.QuestionService;
import com.act.questionanswer.utilities.mapper.ModelConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        Optional<Question> question = Optional.ofNullable(questionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Question not found", null)));
        return converterService.convertToType(question, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAllQuestion() {
        List<Question> questionList = questionRepository.findAll();
        return converterService.mapList(questionList, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAllQuestionByUserId(Integer id) {
        List<Question> questionList = questionRepository.findAllQuestionsByUserId(id);
        return converterService.mapList(questionList, QuestionDto.class);
    }

    @Override
    public QuestionDto updateQuestion(Integer id, QuestionDto updatedQuestionDto) {
        return null;
    }

    @Override
    public void deleteQuestion(Integer id) {
        Question question = questionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Question not found", null));
        questionRepository.delete(question);
    }
}
