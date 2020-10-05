package com.api.sporty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sporty.exceptionHandler.BusinessException;
import com.api.sporty.model.User;
import com.api.sporty.service.UserService;

@RestController
public class UserCRUDController {

	@Autowired
	private UserService service;
	
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/User")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}

	@PutMapping("/User")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@GetMapping("/User/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/User/{id}")
	public void deleteUserById(@PathVariable int id) {
		service.deleteUserById(id);
	}
	
}
