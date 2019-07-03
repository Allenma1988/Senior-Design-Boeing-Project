package com.revature.service;

/*
 * class example
 */

import java.util.List;

import com.revature.model.User;
import com.revature.repository.PostgreSQLImpl;

/*
 * This is the service layer of our application. This is where
 * any business logic should be placed.
 */
public class UserService {

	public List<User> getAllUsers(){
		return new PostgreSQLImpl().getAllUsers();
	}
	
	public void insertUser(User u) {
		new PostgreSQLImpl().insertUser(u);
	}
	
	public void deleteUser(User u) {
		new PostgreSQLImpl().deleteUser(u);
	}
}
