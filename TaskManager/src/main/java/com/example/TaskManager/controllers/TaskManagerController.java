package com.example.TaskManager.controllers;

import java.security.Principal;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;

@Controller
@RequestMapping("/")
public class TaskManagerController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	private Long USER_ID;
	
	@GetMapping(value = {"", "login"})
	public String getLoginPage() {
		return "login";
	}
	
	  @GetMapping("registration")
	  public String registration(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
	  }

    @PostMapping(value = "registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.registerUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully! Login now");
            modelAndView.addObject("user", new User());
            USER_ID = user.getId();
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
	
	@GetMapping("home")
	public String getHomePage(ModelMap model, Principal principal) {
		String username = principal.getName();
		User user = userService.findUserByUserName(username);
		model.addAttribute("user", user);
		USER_ID = user.getId();
		return "home";
	}
	
	
	@GetMapping(path="showFormForAdd")
	public String getCreateForm(ModelMap model) {
		System.out.println(USER_ID);
		Task task = new Task();
		model.addAttribute("task", task);
		return "showForm";
	}
	
	@PostMapping(path="saveTask")
	public String saveTask(Task task) {
		System.out.println(task);
		System.out.println(USER_ID);
		userService.addTask(task, USER_ID);
		return "redirect:/home";
	}
	
	@GetMapping(path="showFormForUpdate")
	public String updateForm(@RequestParam(value="taskId") Long id, ModelMap model) {
		Task task = taskService.findById(id);
		
		model.addAttribute("task", task);
		
		return "updateForm";
		
	}
	
	@PostMapping(path="updateTask")
	public String updateTask(Task task) {
		System.out.println(USER_ID);
		taskService.save(task);
		return "redirect:/home";
	}
	
	@GetMapping(path="delete")
	public String deleteTask(@RequestParam(value="taskId") Long id) {
		taskService.deleteTask(id);
		return "redirect:/home";
	}
}
