package com.moviesapi.controller;


import com.moviesapi.model.User;
//import com.moviesapi.service.UserService;
import com.moviesapi.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;


	@GetMapping("/users")
	List<User> all() {
		return userServiceImpl.findAll();
	}

	@PostMapping("/users")
	User newUser(@RequestBody User newUser) {
		return userServiceImpl.save(newUser);
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Long empid){
		
		User emp=userServiceImpl.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") Long empid,@RequestBody User empDetails){
		
		User emp=userServiceImpl.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setEmail(empDetails.getEmail());
		emp.setPassword(empDetails.getPassword());
		
		User updateUser=userServiceImpl.save(emp);
		return ResponseEntity.ok().body(updateUser);

	}
	
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value="id") Long empid){
		
		User emp=userServiceImpl.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		userServiceImpl.delete(emp);
		
		return ResponseEntity.ok().build();
	}
}
