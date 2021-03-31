package com.example.TaskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManager.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
}
