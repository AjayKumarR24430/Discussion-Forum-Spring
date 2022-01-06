package com.demo.discussionForum.controller;

import com.demo.discussionForum.commons.ResponseMsg;
import com.demo.discussionForum.dto.UserDTO;
import com.demo.discussionForum.model.User;
import com.demo.discussionForum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseMsg signUpUser(@RequestBody final User user) {
        this.userService.signUp(user);
        return new ResponseMsg("sign up successful!!");
    }

    @GetMapping
    public ResponseEntity<Collection<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable final Long id) {
        return new ResponseEntity<>(this.userService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody final User user) {
        return new ResponseEntity<>(this.userService.update(user), HttpStatus.OK);
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<UserDTO> deactivateUserById(@PathVariable final Long id) {
        return new ResponseEntity<>(this.userService.deactivate(id), HttpStatus.OK);
    }

    @PostMapping("/create-admin")
    public void createAdminAccount() {
        userService.createAdmin();
    }
}
