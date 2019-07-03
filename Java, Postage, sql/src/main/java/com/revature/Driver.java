package com.revature;
/*
 * class example
 */
import com.revature.model.User;
import com.revature.service.UserService;

public class Driver {

	public static void main(String[] args) {
		
		UserService us = new UserService();
		
		System.out.println(us.getAllUsers());
		
		User u = new User(2, "Shirley", "pass");
		
		/*
		 * Let's pass that user object to our insert method from
		 * our service layer. It should insert this user into
		 * our database.
		 */
		us.insertUser(u);	
		
	}
}
