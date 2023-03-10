package com.act.questionanswer.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User{
    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Integer id ;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Gender gender ;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL} , fetch = FetchType.LAZY)
    private List<Question> questionList;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL} , fetch = FetchType.LAZY)
    private List<Answer> answerList;


}
