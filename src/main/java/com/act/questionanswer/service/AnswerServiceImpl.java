package com.act.questionanswer.service;

import com.act.questionanswer.exception.ResourceNotFoundException;
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
      Optional<Answer> answer = Optional.ofNullable(answerRepository.findById(id).orElseThrow(
              () -> new ResourceNotFoundException("Answer not found", null)));
      return converterService.convertToType(answer, AnswerDto.class);
    }

    @Override
    public AnswerDto updateAnswer(Integer id, AnswerDto answerDto) {
        Optional<Answer> answer = Optional.ofNullable(answerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Answer not found", null)));
        Answer answerOptional = answer.get();
        answerOptional.setComment(answerDto.getComment());
        answerRepository.save(answerOptional);
        return answerDto;
    }

    @Override
    public List<AnswerDto> getAllAnswerByQuestionId(Integer id) {
        List<Answer> answerList = answerRepository.findAllAnswerByQuestionId(id);
        return converterService.mapList( answerList, AnswerDto.class);
    }

    @Override
    public List<AnswerDto> getAllAnswerByUserId(Integer id) {
        List<Answer> answerList = answerRepository.findAllAnswerByUserId(id);
        return converterService.mapList(answerList,AnswerDto.class) ;
    }

    @Override
    public void deleteAnswer(Integer id) {
        Answer answer = answerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Answer not found",null));
        answerRepository.delete(answer);
    }
}
