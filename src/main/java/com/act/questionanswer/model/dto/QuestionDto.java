package com.act.questionanswer.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private Long id;
    private String title;
    private String subtitle;
    private String message;
    private UserDto user;
    private List<AnswerDto> answerDtoList;
}
