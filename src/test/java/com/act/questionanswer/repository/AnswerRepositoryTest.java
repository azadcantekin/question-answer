package com.act.questionanswer.repository;

import com.act.questionanswer.model.Answer;
import com.act.questionanswer.model.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AnswerRepositoryTest {
    @Autowired
    private AnswerRepository underTest;
    @Autowired
    private QuestionRepository questionRepository;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCreateAnswer(){
        Answer answer = new Answer();

        underTest.save(answer);

        assertEquals(1,underTest.findAll().size());
    }

    @Test
    void itShouldGetAnswerById(){
        Answer answer = new Answer();
        answer.setId(1);
        answer.setComment("try");

        underTest.save(answer);

        Answer savedAnswer = underTest.findById(1).get();

        assertThat(savedAnswer).isEqualTo(answer);

    }

    @Test
    void itShouldUpdate(){
        Answer answer = new Answer();
        answer.setId(1);
        answer.setComment("try");

        underTest.save(answer);

        Answer updateAnswerRequest = new Answer();
        updateAnswerRequest.setComment("try for update");

        Answer savedAnswer = underTest.findById(answer.getId()).get();
        savedAnswer.setComment(updateAnswerRequest.getComment());

        underTest.save(savedAnswer);

        Answer updatedAnswer = underTest.findById(1).get();

        assertEquals(updatedAnswer.getComment(),"try for update");


    }

    @Test
    void itShouldListOfAnswerByQuestionId(){
        Answer answer = new Answer();
        Answer answer1 = new Answer();
        Question question = new Question();
        question.setId(1);
        answer.setQuestion(question);
        questionRepository.save(question);
        underTest.save(answer);
        underTest.save(answer1);

        List<Answer> answerList = underTest.findAllAnswerByQuestionId(question.getId());

        assertThat(answerList.size()).isEqualTo(1);



    }

    @Test
    void itShouldDeleteAnswer(){
        Answer answer = new Answer();

        underTest.save(answer);
        underTest.deleteById(answer.getId());

        assertThat(underTest.findAll().size())
                .isEqualTo(0);
    }
}