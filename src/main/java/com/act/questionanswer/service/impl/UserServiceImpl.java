package com.act.questionanswer.service.impl;


import com.act.questionanswer.config.security.JwtService;
import com.act.questionanswer.exception.ResourceNotFoundException;
import com.act.questionanswer.model.User;
import com.act.questionanswer.model.dto.UserDto;
import com.act.questionanswer.model.request.AuthRequest;
import com.act.questionanswer.repository.UserRepository;
import com.act.questionanswer.service.UserService;
import com.act.questionanswer.utilities.mapper.ModelConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelConverterService converterService;
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = converterService.convertToType(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        userDto.setToken(token);
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
    public UserDto findByEmail(AuthRequest authRequest) {
          Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                  authRequest.getEmail(), authRequest.getPassword()
          ));
        User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException("User not found", null));
        String token = jwtService.generateToken(user);
        UserDto userDto = converterService.convertToType(user, UserDto.class);
        userDto.setToken(token);
        return userDto;
    }


    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found", null));
        userRepository.deleteById(user.getId());
    }
}
