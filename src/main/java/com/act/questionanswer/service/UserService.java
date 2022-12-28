package com.act.questionanswer.service;

import com.act.questionanswer.model.User;

import java.util.Optional;

public interface UserService {

    User createUser(User user);
    User updateUser(Integer id , User updatedUser);
    Optional<User> getUserById(Integer id);
    void deleteUser(Integer id);

}
