package com.act.questionanswer.repository;

import com.act.questionanswer.model.Role;
import com.act.questionanswer.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;



import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;



    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }

    @Test
    void itShouldCreate() {
        //given
        User user = new User();
        user.setFirstName("Azad Can");
        user.setLastName("Tekin");
        user.setEmail("tekin.act@gmail.com");
        List<Role> roleList = new ArrayList<>();
        roleList.add(Role.USER);
        //when
        underTest.save(user);
        //then
        User savedUser = underTest.findById(user.getId()).get();
        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    void itShouldGetByEmail(){
        User user = new User();
        String email = "tekin.act";
        user.setFirstName("ACT");
        user.setEmail(email);

        User savedUser = underTest.save(user);

        User userOptional =  underTest.findByEmail(savedUser.getEmail()).get();
        assertThat(userOptional)
               .isEqualTo(user);

    }

    @Test
    void itShouldUpdateUser(){
        User user = new User();
        user.setId(1);
        user.setFirstName("Azad");

        underTest.save(user);

        User savedUser = underTest.findById(user.getId()).get();
        savedUser.setFirstName("ACT");
        underTest.save(savedUser);

        User updatedUser = underTest.findById(1).get();
        assertThat(updatedUser.getFirstName())
                .isEqualTo("ACT");


    }

    @Test
    void itShouldDelete(){
        User user = new User();
        user.setFirstName("Azad Can");

        User savedUser =   underTest.save(user);

        underTest.deleteById(savedUser.getId());
        assertThat(underTest.findAll()).isEmpty();
    }
}