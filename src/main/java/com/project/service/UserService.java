package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.entities.City;
import com.project.entities.User;

public interface UserService {
//	String addUserDetails(User user);
	
	User addUserDetails(User transientUser);
    List<City> getAllCity();
    Optional<City> getCity(long id) ;
    User checkEmail(String email);
	User restPass(User validuser, String password);
    
}
