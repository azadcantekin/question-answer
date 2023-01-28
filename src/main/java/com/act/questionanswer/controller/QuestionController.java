package com.act.questionanswer.controller;


import com.act.questionanswer.model.dto.QuestionDto;
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
    public ResponseEntity<?> addQuestion(@RequestBody QuestionDto questionDto){
       return ResponseEntity.ok(questionService.addQuestion(questionDto));
    }

    @GetMapping("/get-question")
    public ResponseEntity<?> getQuestion(@RequestParam Integer id){
        return ResponseEntity.ok(questionService.getQuestion(id));
    }
    @GetMapping("/get-all-question")
    public ResponseEntity<?> getAllQuestion(){
        return ResponseEntity.ok(questionService.getAllQuestion());
    }
    @GetMapping("/get-all-question-by-user-id")
    public ResponseEntity<?> getAllQuestionByUserId(@RequestParam Integer id){
        return ResponseEntity.ok(questionService.getAllQuestionByUserId(id));
    }

    @PutMapping("/get-question")
    public ResponseEntity<?> updateQuestion(@RequestParam Integer id , @RequestBody QuestionDto updatedQuestionDto){
        return ResponseEntity.ok(questionService.updateQuestion(id,updatedQuestionDto));
    }

    @DeleteMapping("/delete-question")
    public ResponseEntity<?> deleteQuestion(@RequestParam Integer id){
        questionService.deleteQuestion(id);
        return null;
    }
}
