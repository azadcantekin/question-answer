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
@Table(name = "t_question")
public class Question {
    @Id
    @SequenceGenerator(
            name = "question_id_sequence",
            sequenceName = "question_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_id_sequence"
    )
    private Integer id;
    private String title;
    private String subtitle;
    private String message;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Answer> answerList;
}
