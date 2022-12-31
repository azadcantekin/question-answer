package com.act.questionanswer.service.impl;

import com.act.questionanswer.model.User;
import com.act.questionanswer.repository.UserRepository;
import com.act.questionanswer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id , User updatedUser) {
        Optional<User> user = userRepository.findById(id);
        User userOptional= user.get();
        userOptional.setFirstName(updatedUser.getFirstName());
        userOptional.setLastName(updatedUser.getLastName());
        userOptional.setEmail(updatedUser.getEmail());
        userRepository.save(userOptional);
        return userOptional;
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Integer id) {
    userRepository.deleteById(id);
    }
}
