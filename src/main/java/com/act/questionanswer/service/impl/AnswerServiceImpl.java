package com.act.questionanswer.service.impl;

import com.act.questionanswer.model.Answer;
import com.act.questionanswer.model.dto.AnswerDto;
import com.act.questionanswer.repository.AnswerRepository;
import com.act.questionanswer.service.AnswerService;
import com.act.questionanswer.utilities.mapper.ModelConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final ModelConverterService converterService;

    @Override
    public AnswerDto addAnswer(AnswerDto answerDto) {
       answerRepository.save(converterService.convertToType(answerDto, Answer.class));
       return answerDto;
    }

    @Override
    public AnswerDto getAnswer(Integer id) {
      Optional<Answer> answer = answerRepository.findById(id);
      return converterService.convertToType(answer, AnswerDto.class);
    }

    @Override
    public AnswerDto updateAnswer(Integer id, AnswerDto answerDto) {
        return null;
    }

    @Override
    public List<AnswerDto> getAllAnswerByQuestionId(Integer id) {
        return converterService.mapList( answerRepository.findAllAnswerByQuestionId(id), AnswerDto.class);
    }

    @Override
    public List<AnswerDto> getAllAnswerByUserId(Integer id) {
        return converterService.mapList(answerRepository.findAllAnswerByUserId(id),AnswerDto.class) ;
    }

    @Override
    public void deleteAnswer(Integer id) {
        answerRepository.deleteById(id);
    }
}
