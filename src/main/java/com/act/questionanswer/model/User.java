package com.act.questionanswer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","questionList","answerList"})
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
    private List<Role> roleList;
    private Gender gender ;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Question> questionList;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
