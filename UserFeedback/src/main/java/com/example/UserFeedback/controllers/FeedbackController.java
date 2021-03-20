package com.example.UserFeedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
	@GetMapping("/feedback")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedback();
    }
	
	@PostMapping("/feedback")
	public Feedback addNewFeedback(@RequestBody Feedback newFeedback) {
		// TODO: Do something useful here.  
		Feedback temp = new Feedback(newFeedback.getComment(), newFeedback.getRating(), newFeedback.getUserName());
		Feedback feedback = feedbackService.save(temp);
		logger.info("Successfully added " + feedback + " to the database!!!");
		return feedback;  
	}
}
