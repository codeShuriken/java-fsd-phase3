package com.example.UserManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserManager.entities.User;
import com.example.UserManager.exceptions.UserNotFoundException;
import com.example.UserManager.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	
	

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id) {
    	Optional<User> foundUser = userRepository.findById(id);
    	    	
    	if (!foundUser.isPresent()) {
    		return null;
    	}
    	
    	return (foundUser.get());
    }
    
    public void updateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }
}
