package com.example.Authentication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByName(String userName) {
        User foundUser = userRepository.findByUserName(userName);
        return foundUser;
    }
    
    public User getUserByCredentials(String name, String password) {
        User foundUser = userRepository.findByCredentials(name, password);
        return foundUser;
    }
    
    public User getUserById(int id) {
    	Optional<User> foundUser = userRepository.findById(id);
    	
    	if (!foundUser.isPresent()) {
    		return null;
    	}
    	
    	return(foundUser.get());
    }
    
}
