package com.act.questionanswer.controller;


import com.act.questionanswer.model.dto.UserDto;
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
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.createUser(userDto));
    }
    @GetMapping("/get-user")
    public ResponseEntity<?> getUser(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UserDto updatedUserDto , @PathVariable Integer id){
        return ResponseEntity.ok(userService.updateUser(id,updatedUserDto));
    }
    @DeleteMapping("/delete-user")
    public void deleteUser( @RequestParam Integer id){
       userService.deleteUser(id);
    }
}
