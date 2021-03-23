package com.example.Authentication.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Authentication.entities.User;
import com.example.Authentication.exceptions.InvalidCredentialsException;
import com.example.Authentication.exceptions.UserNotFoundException;
import com.example.Authentication.services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
    @GetMapping("/")
    public String showGreeting() {
        return "greeting";
    }
    
    @GetMapping("/users")
    public String getUsers(ModelMap model) {
    	Iterable<User> users  = userService.getAllUsers();
    	model.addAttribute("users", users);
    	return "users";
    }
    
    @GetMapping("/getUser")
    public String getUser() {
    	return "getUser";
    }

    @GetMapping("/login")
    public String showLogin(ModelMap map) {
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam(name="userName") String userName, @RequestParam(name="password") String password, ModelMap model){
    	System.out.println("Logging in user with username" + userName + " and password " + password);
    	User user = userService.getUserByCredentials(userName, password);
    	if (user != null) {
    		model.addAttribute("user", user);
    		System.out.println("Here");
    		return "welcome";
    	}
        throw new InvalidCredentialsException();
    }
    
    @GetMapping("/userData")
    public String getUserByID(@RequestParam(name="id")int id, ModelMap model) {
    	User user = userService.getUserById(id);
    	model.addAttribute("user", user);
    	model.addAttribute("id", id);
    	if (user != null)return "userData";
    	throw new UserNotFoundException(id);
        
    }
    
    @GetMapping("/logout")
    public String logout(ModelMap model) {
    	model.remove("user");
    	return "greeting";
    }
}
