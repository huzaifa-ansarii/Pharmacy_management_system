package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.City;
import com.project.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	User findByEmailAndPassword(String email,String password);
	User findByEmail(String email);

}


