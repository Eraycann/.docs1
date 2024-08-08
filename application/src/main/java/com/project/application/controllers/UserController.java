package com.project.application.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.ResponseEntity;

import com.project.application.entities.User;
import com.project.application.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // /users için GET işlemi
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // /users için POST işlemi
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }
    
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
    	return userService.getOneUser(userId);
    }	

    // /users/{userId} için PUT işlemi
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
      return userService.updateOneUser(userId, newUser);
    }
    
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
    	userService.deleteById(userId);
    }
}
