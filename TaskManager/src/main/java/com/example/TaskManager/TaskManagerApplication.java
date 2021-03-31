package com.example.TaskManager;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.repositories.UserRepository;

import jdk.internal.org.jline.utils.Log;

@SpringBootApplication
public class TaskManagerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

}
