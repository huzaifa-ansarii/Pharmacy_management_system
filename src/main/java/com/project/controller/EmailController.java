package com.project.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Credentials;
import com.project.dto.OtpDto;
import com.project.entities.User;
import com.project.service.EmailService;
import com.project.service.UserService;





@CrossOrigin(origins = "*") 
@RestController


public class EmailController{
	Random random=new Random(1000);
	
	@Autowired
	private EmailService emailservice;
	
    @Autowired
    private UserService userService;
	
	@PostMapping("/sendotp")
	public ResponseEntity<?> Signup(@RequestBody Credentials cred) {	
		
		
	   OtpDto otpDetails = null;
	
		
	     
		
		User validuser=userService.checkEmail(cred.getEmail());
		System.out.println(cred.getEmail());
		if(validuser!=null) {
			System.out.println("user found for otp");
			
			int otp=random.nextInt(999999);
			String subject ="OTP from pharmacy management system";
			String message="your Reset password message OTP = "+otp+" ";
			String to=cred.getEmail();
			boolean flag=emailservice.sendEmail(subject, message, to);		
			if(flag) {
				otpDetails=new OtpDto(otp,"success");
			}else {
				otpDetails=new OtpDto(otp,"failure");
			}
		}else{
			System.out.println("Ohhh sorrry ");
		}
				 
		return new ResponseEntity<>(otpDetails,HttpStatus.OK);
	}
	
	
	@PostMapping("/resetPassword")
	public ResponseEntity<?> resetPassword(@RequestBody Credentials cred){
		System.out.println(cred.toString());
		System.out.println("inside passwordreset");
		System.out.println(cred.getEmail());
		System.out.println(cred.getPassword());
		User validuser=userService.checkEmail(cred.getEmail());
		System.out.println(validuser);
		User persistentUser=userService.restPass(validuser,cred.getPassword());
		if(persistentUser!=null) {
			System.out.println("successfully changed the password");
			return new ResponseEntity<>("Password changed sucessfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Password Not changed",HttpStatus.OK);
		}
		
	}
	
	
	
	

}
