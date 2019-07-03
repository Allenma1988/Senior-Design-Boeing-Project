package com.revature.repository;

import java.util.List;

import com.revature.model.User;

public interface UserRepository {

	public List<User> getAllUsers();
	public User getUserById(int id);
	public void insertUser(User u);
	public void updateUser(User u);
	public void deleteUser(User u);
}
