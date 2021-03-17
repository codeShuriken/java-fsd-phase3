package com.example.UserManager.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		logger.info("Getting all Users");
		Iterable<User> users = userService.getAllUsers();  
		
		logger.info("Passing users to view");
	    model.addAttribute("users", users);    
		
        return "users";
    }
	
	@GetMapping("/updateUser")
	public String updateUser(ModelMap model) {
        return "updateUser";
    }
	
	
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("userID") int id, ModelMap model) {
		User user = userService.getUserById(id);
		model.addAttribute("id", id);
		if (user == null) {
			return "error_page";
		}
		
		model.addAttribute("user", user);
		
		return "user_form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user, ModelMap model) {
		userService.updateUser(user);
		model.addAttribute("user", user);
		return "success_page";
	}
}
