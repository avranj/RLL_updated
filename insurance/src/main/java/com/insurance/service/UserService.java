package com.insurance.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.insurance.dao.UserDao;
import com.insurance.entity.Policy;
import com.insurance.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	
	// create by user only but keep policynum null at this time
	public User addUser(User user) {
		return userdao.save(user);
	}
	
	
	
	// read
	public User getUserById(int id){
		return userdao.findById(id).orElse(null);
		
	}
	// read by name
	//public User getUserByName(String name) {
		//return userdao.findByName(name);
		
	//}
	
	// read by policynumber
	
	
	//  delete if a user want to complete delete their existence
	public String deleteUser(int id) {
		userdao.deleteById(id);
		return "user deleted"+id ;
		
	}
	
	// update user through user, but only sum parameters
	
	public User updateUser(User user) {
		
		User existinguser = userdao.findById(user.getUserId()).orElse(null);
		existinguser.setAddress(user.getAddress());
		existinguser.setName(user.getName());
		existinguser.setPassword(user.getPassword());
		existinguser.setPhoneNum(user.getPhoneNum());
		// doubt existinguser.setEmail(user.getEmail());
		//existinguser.setPolicyNum(null);
		return userdao.save(existinguser);
		
		
		
	}
	

}
