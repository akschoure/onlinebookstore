package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.pojos.User;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	public UserRepository userRepo;


	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}


	@Override
	public User getUserDetails(int userid) {
		return userRepo.findById(userid).orElseThrow();
	}


	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}


	@Override
	public String deleteUser(int userid) {
		userRepo.deleteById(userid);
		return "user deleted "+userid;
	}


	@Override
	public User updateUser(User detachUser) {
		return userRepo.save(detachUser);
	}


	@Override
	public User loginUser(String emailid, String password) {
		
		return userRepo.findByEmailidAndPassword(emailid, password);
	}



	

	
	

}