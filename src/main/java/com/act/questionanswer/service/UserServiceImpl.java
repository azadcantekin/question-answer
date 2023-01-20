package com.act.questionanswer.service;


import com.act.questionanswer.exception.ResourceNotFoundException;
import com.act.questionanswer.model.User;
import com.act.questionanswer.model.dto.UserDto;
import com.act.questionanswer.repository.UserRepository;
import com.act.questionanswer.utilities.mapper.ModelConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelConverterService converterService;

    @Override
    public UserDto createUser(UserDto userDto) {
            userRepository.save(converterService.convertToType(userDto, User.class));
            return userDto;

    }

    @Override
    public UserDto updateUser(Integer id, UserDto updatedUserDto) {
        Optional<User> user = Optional.ofNullable(userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found", null)));
        User userOptional = user.get();
        userOptional.setFirstName(updatedUserDto.getFirstName());
        userOptional.setLastName(updatedUserDto.getLastName());
        userOptional.setEmail(updatedUserDto.getEmail());
        userRepository.save(userOptional);
        return updatedUserDto;
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found", null));
        return converterService.convertToType(user, UserDto.class);

    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found", null));
        userRepository.deleteById(user.getId());
    }
}
