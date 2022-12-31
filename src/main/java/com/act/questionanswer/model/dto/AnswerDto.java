package com.act.questionanswer.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private Long id;
    private String comment;
    private String attachmentUrl;
    private QuestionDto question;
    private UserDto user;
}
