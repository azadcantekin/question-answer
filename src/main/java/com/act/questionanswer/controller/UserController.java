package com.act.questionanswer.controller;

import com.act.questionanswer.model.User;
import com.act.questionanswer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
    @GetMapping("/get-user")
    public ResponseEntity<?> getUser(@RequestParam Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody User updatedUser , @PathVariable Integer id){
        return ResponseEntity.ok(userService.updateUser(id,updatedUser));
    }
    @DeleteMapping("/delete-user")
    public void deleteUser( @RequestParam Integer id){
       userService.deleteUser(id);
    }
}
