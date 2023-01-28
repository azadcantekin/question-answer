package com.act.questionanswer.service;

import com.act.questionanswer.model.dto.UserDto;
import com.act.questionanswer.model.request.AuthRequest;


public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(Integer id , UserDto updatedUserDto);
    UserDto findByEmail(AuthRequest authRequest);

    void deleteUser(Integer id);

}
