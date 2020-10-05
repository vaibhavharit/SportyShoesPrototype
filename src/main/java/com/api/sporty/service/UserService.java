package com.api.sporty.service;

import java.util.List;

import com.api.sporty.exceptionHandler.BusinessException;
import com.api.sporty.model.User;

public interface UserService {
	
	public User createUser(User user);
	public User updateUser(User user);
	public User getUserById(int id) throws BusinessException;
	public void deleteUserById(int id);
	
	public List<User> getAllUsers();
	public List<User> getAllUsersByName(String name);
	public List<User> getAllUsersByRole(String role);

}
