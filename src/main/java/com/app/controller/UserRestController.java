package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.User;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRestController {
	
	@Autowired
	public UserServiceImpl userService;
	
	@GetMapping
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	

	//get user by id
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> getUserDetails(@PathVariable int userid)
	{
		System.out.println("");
		try {
			return ResponseEntity.ok(userService.getUserDetails(userid));
			
		    } catch (RuntimeException e)
	  	     {
			   return new ResponseEntity<>(new ErrorResponse("Fetch user fail", e.getMessage()),HttpStatus.BAD_REQUEST);
	         }
		
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> addUser( @RequestBody User user)
	{
		System.out.println("");
		try {
			return ResponseEntity.ok(userService.addUser(user));
			
		} catch (RuntimeException e) {
			
			return new ResponseEntity<>(new ErrorResponse("fail to add", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable int userid)
	{
		System.out.println("");
		
		return ResponseEntity.ok(new ResponseDTO(userService.deleteUser(userid)));
	}
	
	
	@PutMapping("/{userid}")
	public ResponseEntity<?> updateUser(@RequestBody User detachUser , @PathVariable int userid)
	{
		System.out.println("");
		try {
			User exstingUser = userService.getUserDetails(userid);
			return ResponseEntity.ok(userService.updateUser(detachUser));
			
		} catch (RuntimeException e) {
			
			return new ResponseEntity<> (new ErrorResponse("User update failed !!",e.getMessage()),HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
	@PostMapping("/login/{emailid}/{password}")
	public ResponseEntity<?> loginUser(@PathVariable String emailid , @PathVariable String password)
	{
		System.out.println("");
//		try {
			User exstingUser = userService.loginUser(emailid, password);
			if(exstingUser!=null)
			return ResponseEntity.ok(exstingUser);
//		} catch (RuntimeException e) {
			
			return new ResponseEntity<> (new ErrorResponse("User Not Found failed !!","error"),HttpStatus.BAD_REQUEST);
//                   ErrorResponse error = new ErrorResponse("Login Failed : Invalid credential", e.getMessage()),HttpStatus.BAD_REQUEST);
//                   return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<> (new ErrorResponse("User update failed !!","error"),HttpStatus.NOT_FOUND);
	}
	

}
