package com.example.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findUserByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		//System.out.println(user);
		return user;
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(long id) {
		//System.out.println("getUserById:" + id);
		Optional<User> user = userRepository.findById((long) id);
		return user.isPresent() ? user.get() : null;
	}
	
}
