package com.act.questionanswer.service;

import com.act.questionanswer.exception.ResourceNotFoundException;
import com.act.questionanswer.model.User;
import com.act.questionanswer.model.dto.UserDto;
import com.act.questionanswer.repository.UserRepository;
import com.act.questionanswer.service.impl.UserServiceImpl;
import com.act.questionanswer.utilities.mapper.ModelConverterService;
import com.act.questionanswer.utilities.mapper.ModelConverterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    private UserService underTest;
    @Mock
    private ModelConverterService modelConverterService;
    @Captor
    ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

    @BeforeEach
    void setUp() {
        modelConverterService = new ModelConverterServiceImpl(new ModelMapper());
        underTest = new UserServiceImpl(userRepository, modelConverterService);

    }

    @Test
    void createUser() {
        //given
        User user = new User();
        user.setFirstName("azad can");
        user.setLastName("tekin");
        user.setEmail("tekin.act@icloud.com");
        user.setPassword("act");
        //when
        UserDto userDto = modelConverterService.convertToType(user, UserDto.class);
        underTest.createUser(userDto);
        //then
        verify(userRepository).save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void updateUser() {
        User user = new User();
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        UserDto updateUserRequest = new UserDto();
        updateUserRequest.setFirstName("act");

        UserDto result = underTest.updateUser(1, updateUserRequest);
        verify(userRepository).save(userArgumentCaptor.capture());

        User updatedUser = userArgumentCaptor.getValue();

        assertThat(modelConverterService.convertToType(updatedUser, UserDto.class))
                .isEqualTo(result);
    }

    @Test
    void getUserById() throws Exception {
        User user = new User();
        user.setId(1);
        user.setFirstName("act");
        user.setLastName("tekin");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        UserDto result = underTest.getUserById(1);

        verify(userRepository).findById(1);

        assertThat(result)
                .isEqualTo(modelConverterService.convertToType(user, UserDto.class));


    }
    @Test
    void willThrownWhenUserNotFound() {
        User user = new User();
        user.setId(1);

        assertThatThrownBy(()-> underTest.getUserById(0))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("User not found");

        verify(userRepository).findById(any());

    }

}