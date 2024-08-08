package com.project.application.services;

import org.springframework.stereotype.Service;

import java.util.Optional;
import org.springframework.http.ResponseEntity;

import com.project.application.entities.User;
import com.project.application.repos.UserRepository;
import java.util.List; // List sınıfını import etmek gerekir

@Service
public class UserService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User getOneUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public ResponseEntity<User> updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
	    if (user.isPresent()) {
	        User foundUser = user.get();
	        foundUser.setUserName(newUser.getUserName());
	        userRepository.save(foundUser);
	        return foundUser;
	    } 
	    else {
	        return null;
	    }
	}

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}	
}
