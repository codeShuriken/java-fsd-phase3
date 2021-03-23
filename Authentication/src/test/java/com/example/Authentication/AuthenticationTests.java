package com.example.Authentication;

import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;
import com.example.Authentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

@DataJpaTest
public class AuthenticationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void whenFindByName_thenReturnUser() {
        User dummyUser = new User("Dummy", "test@test.com", "password");
        entityManager.persist(dummyUser);
        entityManager.flush();
        
        User found = userRepository.findByUserName(dummyUser.getUserName());
        assertEquals(found.getUserName(), dummyUser.getUserName());
    }
    
    @Test
    public void testFindById() {
        User dummyUser = new User("gowt", "gowt@test.com", "password");
        entityManager.persist(dummyUser);
        entityManager.flush();
        
        Optional<User> found = userRepository.findById(dummyUser.getId());
        assertNotNull(found.get());
    }
    
    @Test
    public void testFindAll() {
    	  User dummyUser = new User("Dummy", "test@test.com", "password");
          entityManager.persist(dummyUser);
          entityManager.flush();
	     
    	Iterable<User> users  = userRepository.findAll();
    	int cnt = 0;
    	for(User u : users)
    		cnt++;
    	assertEquals(cnt, 1);
    }
    
    @Test
    public void testGetUserByCredentials() {
		User dummyUser = new User("gowt", "gowt@test.com", "password");
	    entityManager.persist(dummyUser);
	    entityManager.flush();
	    
    	String userName = dummyUser.getUserName(), password = dummyUser.getPassword();
    	User user= userRepository.findByCredentials(userName, password);
    	assertNotNull(user);
    }
}