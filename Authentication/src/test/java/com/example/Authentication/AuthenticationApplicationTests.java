package com.example.Authentication;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;

@SpringBootTest
class AuthenticationApplicationTests {
	@Autowired
	public UserService userService;
	
	@Test
	void contextLoads() throws Exception{
		assertNotNull(userService);
	}
	
	@Test
	void testGetAllUsers() {
		Iterable<User> users = userService.getAllUsers();
		int count = 0;
		for (User user : users) {
			++count;
		}
		assertNotEquals(count, 0);
	}
	
	@Test
	void testGetUserByName() {
		String name = "gowt";
		User found  = userService.getUserByName(name);
		assertNotNull(found);
	}
	
	@Test
	void testInvalidUserByName() {
		String name = "xxxxxx";
		User found  = userService.getUserByName(name);
		assertNull(found);
	}
	
	@Test
	void testUserByCredentials() {
		String userName = "gowt", password = "9999";
		User found  = userService.getUserByCredentials(userName, password);
		assertNotNull(found);
	}
	
	@Test
	void testInvalidCredentials() {
		String userName = "gowt", password = "gowt";
		User found  = userService.getUserByCredentials(userName, password);
		assertNull(found);
	}
	
	@Test
	void testGetUserById() {
		int id = 3;
		User found  = userService.getUserById(id);
		assertNotNull(found);
	}
	
	@Test
	void testInvalidGetUserById() {
		int id = 3333;
		User found  = userService.getUserById(id);
		assertNull(found);
	}
}
