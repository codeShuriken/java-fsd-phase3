package com.example.SpringSecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUserName(String userName);
	
	public User findByEmail(String email);

}
