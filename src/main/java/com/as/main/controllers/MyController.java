package com.as.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.main.entities.User;
import com.as.main.services.UserService;

@RestController
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUserDetails()
	{
		return userService.getAllUser();
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable int id,@RequestBody User user)
	{
		User updatedUser=userService.updateUserDeatils(id, user);
		if(updatedUser!=null)
		{
			return ResponseEntity.ok(updatedUser);
		}
		return ResponseEntity.notFound().build(); 
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetail(@PathVariable int id)
	{
		User user=userService.getUserDetail(id).orElse(null);
		
		if(user!=null)
		{
			return ResponseEntity.ok().body(user);
		}
		else
		{
			return ResponseEntity.notFound().build();
			
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable int id)
	{
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
