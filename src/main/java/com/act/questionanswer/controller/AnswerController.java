package com.act.questionanswer.controller;

import com.act.questionanswer.model.Answer;
import com.act.questionanswer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;


    @PostMapping("/add-answer")
    public ResponseEntity<?> addAnswer(@RequestBody Answer answer){
        return ResponseEntity.ok(answerService.addAnswer(answer));
    }

    @GetMapping("/get-answer")
    public ResponseEntity<?> getAnswer(@RequestParam Integer id){
        return ResponseEntity.ok(answerService.getAnswer(id));
    }

    @GetMapping("/get-all-answer-by-question-id")
    public ResponseEntity<?> getAllAnswerByQuestionId(@RequestParam Integer id){
        return ResponseEntity.ok(answerService.getAllAnswerByQuestionId(id));
    }

    @GetMapping("/get-all-answer-by-user-id")
    public ResponseEntity<?> getAllAnswerByUser(@RequestParam Integer id){
        return ResponseEntity.ok(answerService.getAllAnswerByUserId(id));
    }

    @DeleteMapping("/delete-question")
    public ResponseEntity<?> deleteQuestion(@RequestParam Integer id){
        answerService.deleteAnswer(id);
        return null;
    }
}
