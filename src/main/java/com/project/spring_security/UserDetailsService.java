package com.project.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.entities.User;
import com.project.repository.UserRepo;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	UserRepo userDao;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			User user = userDao.findByEmail(email);
			if(user!=null) {
				return user;
			}
		
		return null;
	}

}
