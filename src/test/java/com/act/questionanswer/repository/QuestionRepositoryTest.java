package com.act.questionanswer.repository;

import com.act.questionanswer.model.Question;
import com.act.questionanswer.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository underTest;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCreate(){
        Question question = new Question();
        question.setMessage("question has been created");
        underTest.save(question);

        assertEquals(1,underTest.findAll().size());
    }
    @Test
    void itShouldFindById(){
        Question question = new Question();
        question.setMessage("question has been created");
        underTest.save(question);

        Question savedQuestion = underTest.findById(question.getId()).get();
        assertThat(savedQuestion).isEqualTo(question);
    }

    @Test
    void itShouldUpdateQuestion(){
        Question question = new Question();
        question.setMessage("question has been created");
        underTest.save(question);
        Question savedQuestion = underTest.findById(question.getId()).get();
        savedQuestion.setMessage("question has been updated");

        underTest.save(savedQuestion);

        Question updatedQuestion = underTest.findById(question.getId()).get();
        assertThat(updatedQuestion.getMessage()).isEqualTo("question has been updated");
    }

    @Test
    void itShouldGetAllQuestion(){
        Question question = new Question();
        Question question1 = new Question();
        question.setTitle("Software");
        question1.setTitle("Math");

        underTest.save(question);
        underTest.save(question1);

        List<Question> questionList = underTest.findAll();
        assertEquals(2 , questionList.size());
    }

    @Test
    void itShouldDeleteQuestion(){
        Question question = new Question();
        underTest.save(question);

        underTest.deleteById(question.getId());

        assertThat(underTest.findAll()).hasSize(0);
    }

    @Test
    void itShouldGetAllQuestionByUserId(){
        Question question = new Question();
        User user = new User();
        user.setId(1);
        Question question1 = new Question();
        userRepository.save(user);

        question.setUser(user);

        underTest.save(question);
        underTest.save(question1);


        List<Question> questionList = underTest.findAllQuestionsByUserId(user.getId());

        assertThat(questionList).hasSize(1);
    }

}