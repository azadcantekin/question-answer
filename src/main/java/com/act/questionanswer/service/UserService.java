package com.act.questionanswer.service;

import com.act.questionanswer.model.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(Integer id , UserDto updatedUserDto);
    UserDto getUserById(Integer id) throws Exception;
    void deleteUser(Integer id);

}
