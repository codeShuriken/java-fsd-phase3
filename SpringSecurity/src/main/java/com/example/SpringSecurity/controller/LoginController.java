package com.example.SpringSecurity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	UserService userService;
	
	@GetMapping(value={"","login"})
    public String showLogin() {
    	
        return "login";
    }

    @GetMapping(value={"home"})
    public String showCourses() {
        System.out.println();
        return "home";
    }


    @GetMapping("users")
    public String getUsers(ModelMap model) {
    	Iterable<User> users  = userService.getAllUsers();
    	model.addAttribute("users", users);
    	return "users";
    }
    
    @GetMapping("getUser")
    public String getUser() {
    	return "getUser";
    }

    @GetMapping("userData")
    public String getUserByID(@RequestParam(name="id")Long id, ModelMap model) {
    	User user = userService.getUserById(id);
    	model.addAttribute("user", user);
    	model.addAttribute("id", id);
    	if (user != null)return "userData";
    	System.out.println("Here");
    	return "error-page";
    }
}
