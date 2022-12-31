package com.act.questionanswer.controller;

import com.act.questionanswer.model.Question;
import com.act.questionanswer.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/add-question")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
       return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @GetMapping("/get-question")
    public ResponseEntity<?> getQuestion(@PathVariable Integer id){
        return ResponseEntity.ok(questionService.getQuestion(id));
    }
    @GetMapping("/get-all-question")
    public ResponseEntity<?> getAllQuestion(){
        return ResponseEntity.ok(questionService.getAllQuestion());
    }
    @GetMapping("/get-all-question-by-user-id")
    public ResponseEntity<?> getAllQuestionByUserId(@PathVariable Integer id){
        return ResponseEntity.ok(questionService.getAllQuestionByUserId(id));
    }

    @PutMapping("/get-question")
    public ResponseEntity<?> updateQuestion(@PathVariable Integer id , @RequestBody Question updatedQuestion){
        return ResponseEntity.ok(questionService.updateQuestion(id,updatedQuestion));
    }

    @DeleteMapping("/delete-question")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer id){
        questionService.deleteQuestion(id);
        return null;
    }
}
