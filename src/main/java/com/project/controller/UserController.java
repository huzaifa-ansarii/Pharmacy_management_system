package com.project.controller;

import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.City;
import com.project.dto.AuthResponse;
import com.project.dto.Credentials;

import com.project.entities.Role;
import com.project.entities.User;
import com.project.dto.UserDto;
import com.project.jwt.JWTUtility;
import com.project.repository.UserRepo;
import com.project.service.UserService;



@CrossOrigin
@RestController@PermitAll
public class UserController {
	
	@Autowired
    private UserService userService; 
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    private UserDetailsService userService1;
	
	
	@PostMapping 
	public ResponseEntity<?> addNewUser(@RequestBody @Valid UserDto user1) // @RequestBody : un amrashlling (json ---> java)
	{
		System.out.println("in add user " + user1);
		
		User user = new User();
		user.setAddress(user1.getAddress());
		user.setEmail(user1.getEmail());
		user.setFull_name(user1.getFull_name());
		user.setGst_no(user1.getGst_no());
		user.setLicence_id(user1.getLicence_id());
		user.setMobile_no(user1.getMobile_no());
		user.setPassword(user1.getPassword());
		if(user1.getRole().equals("PHARMACY")) 
		{
		     user.setRole(Role.PHARMACY);	
		}
		else {
			user.setRole(Role.DISTRIBUTOR);
		}
		Optional<City> c = userService.getCity(user1.getCity_id());
	    user.setCity_id(c.get());
		
		return  new ResponseEntity<>(userService.addUserDetails(user),HttpStatus.CREATED);
	
	}
	
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody Credentials cred) throws Exception { 
		
		
		     User u = userRepo.findByEmailAndPassword(cred.getEmail(), cred.getPassword());
		      
		     if(u!=null) 
		     {
		    	 System.out.println(u.getFull_name());
		    	 return new ResponseEntity<>(u,HttpStatus.OK);
		     }
		     else 
		    	 return new ResponseEntity<>("invalid Credentials",HttpStatus.OK);
		
		//token generation code 
//		System.out.println("befor try");
//		System.out.println(cred.getEmail());
//		System.out.println();
//		try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                    		cred.getEmail(),
//                    		cred.getPassword()
//                    )
//            );
//        } catch (BadCredentialsException e) {
//        	System.out.println("invalid user");
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//
//		System.out.println("before load");
//        final UserDetails userDetails
//                = userService1.loadUserByUsername(cred.getEmail());
//        System.out.println("after load");
//
//        final String token =
//                jwtUtility.generateToken(userDetails);
//
//		
//		User user=userRepo.findByEmailAndPassword(cred.getEmail(), cred.getPassword());
//		System.out.println(user);
//		if(user!=null) {
//		         AuthResponse res = new AuthResponse();
//				cred.setToken(token);
//				res.setCred(cred);
//				res.setUser(user);
//				System.out.println("token");
//				return new ResponseEntity<>(res,HttpStatus.OK);
//			
//				
//			
//		}
//		else
//			System.out.println("invalid");
//		return new ResponseEntity<>("invalid_user",HttpStatus.OK);
		
	}
	
	@GetMapping("/getcity")
	public ResponseEntity<?> getCity()
	{
		return new ResponseEntity<>(userService.getAllCity(),HttpStatus.OK);
	}
	
	
	@PostMapping("/resetpassword")
	public ResponseEntity<?> resetPassword(@RequestBody Credentials cred){
		User u = userRepo.findByEmail(cred.getEmail());
		User persistentUser=userService.restPass(u,cred.getPassword());
		if(persistentUser!=null) 
		{
			
			return new ResponseEntity<>("user found",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<>("user not found",HttpStatus.OK);
		}
		
	}
	
	
}
