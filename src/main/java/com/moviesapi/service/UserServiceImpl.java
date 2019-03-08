package com.moviesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesapi.exception.UserNotFoundException;
import com.moviesapi.model.User;
import com.moviesapi.repository.UserRepository;



@Service("userService") 
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
	}
	

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findOne(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));
	}

	public void delete(User user) {
		userRepository.delete(user);
	}
	
}