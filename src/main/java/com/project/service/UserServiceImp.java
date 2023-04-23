package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entities.City;
import com.project.entities.User;
import com.project.repository.CityRepo;
import com.project.repository.UserRepo;

@Service
@Transactional
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CityRepo cityRepo;
	
	@Override
	public User addUserDetails(User transientUser) {
		
		
		return userRepo.save(transientUser);
		
	}
	
	@Override
	public List<City> getAllCity() {
		return cityRepo.findAll();
	}
	
	@Override
	public Optional<City> getCity(long id) 
	{
		return cityRepo.findById(id);
	}

	@Override
	public User checkEmail(String email) {
		User validuser=userRepo.findByEmail(email);
		return validuser;
	}


	@Override
	public User restPass(User validuser, String password) {
		System.out.println("inside userservice");
		System.out.println(validuser);
		validuser.setPassword(password);
		User persistentUser=userRepo.save(validuser);
		return persistentUser;
	}

	
	
	
}





















//@Override
//public String addUserDetails(User user) {
//	
//	User newUser = getUserFromUserModel(user);
//	User persistentUser = userRepo.save(newUser);
//	System.out.println(persistentUser);
//	return "User registered with ID = "+persistentUser.getId();	
//	
//}
//private User getUserFromUserModel(User user) {
//	
//	return new User(user.getName(),user.getAddress(),user.getCity(),user.getState(),user.getPincode(),
//			        user.getEmail(),user.getMobile_no(),user.getPassword(),user.getDob(),user.getGender(),user.getContact_person()
//			        ,user.getCompany_website(),user.getRole_in_company(),user.getQualification_details()
//			        ,user.getUser_type());
//}
//



//User getUserFromUserModel(UserModel userModel) {
//	List<UserRole> roles = new ArrayList<UserRole>();
//	UserRole userRole = userRoleDao.findById(2L).get(); // as a customer
//	System.out.println("userRole ******* " + userRole);
//	roles.add(userRole);
//	long id = userRole.getId();
//	System.out.println("id ::: " +id);
//	return new User(userModel.getName(), userModel.getAddress(), 
//			userModel.getEmail(), userModel.getPassword(), userRole);
//}

