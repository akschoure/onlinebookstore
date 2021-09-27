package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {
	
	List <User> getAllUser();
	
	User getUserDetails (int userid);
	
	User addUser (User user);
	
	String deleteUser (int userid);
	
	User updateUser (User detachUser);
	
	User loginUser(String emailid , String password);

}
