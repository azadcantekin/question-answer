package com.act.questionanswer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @SequenceGenerator(
            name = "answer_id_sequence",
            sequenceName = "answer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_id_sequence"
    )
    private Integer id;
    private String comment;
    private String attachmentUrl;
    @ManyToOne
    private Question question;
    @ManyToOne
    private User user;
}
