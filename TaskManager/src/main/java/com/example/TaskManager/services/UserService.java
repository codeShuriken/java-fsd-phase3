package com.example.TaskManager.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	  
	@Transactional
	public void addTask(Task task, long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			user.get().addTask(task);
			System.out.println(user.get());
		}
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User findUserByUserName(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        return userRepository.save(user);
	}

}
