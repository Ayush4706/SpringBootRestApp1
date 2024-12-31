package com.as.main.services;

import java.util.List;
import java.util.Optional;

import com.as.main.entities.User;

public interface UserService {
	
	public User createUser(User user);
	public List<User> getAllUser();
	public Optional<User> getUserDetail(int id);
	public User updateUserDeatils(int id,User user);
	public void deleteUser(int id);
	
}
