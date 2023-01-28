package com.act.questionanswer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String role;
    private String token ;
    private List<QuestionDto> questionDtoList;
    private List<AnswerDto> answerDtoList;


}
