package com.act.questionanswer.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {
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
    @Enumerated
    private List<Role> roleList;
    @Enumerated
    private Gender gender ;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.REMOVE} , fetch = FetchType.LAZY)
    private List<Question> questionList;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.REMOVE} , fetch = FetchType.LAZY)
    private List<Answer> answerList;
}
