package com.example.Authentication.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.Authentication.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserName(String userName);
	
	@Query("select u from User u where u.userName=:userName and u.password=:password")
    public User findByCredentials(@Param("userName")String userName, @Param("password")String password);
    
}