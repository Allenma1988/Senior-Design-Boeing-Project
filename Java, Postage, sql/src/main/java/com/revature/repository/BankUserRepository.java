package com.revature.repository;

import java.util.List;

import com.revature.model.BankUser;
import com.revature.model.BankChecking;
import com.revature.model.BankSaving;
import com.revature.model.JoinAccount;
import com.revature.model.JoinUser;

public interface BankUserRepository {

	
	public List<BankUser> getAllUsers();
	public BankUser getUserById(int id);
	public BankUser getUserByUserName(String userName);
	public void insertUser(BankUser u);
	public void updateUser(BankUser u);
	public void deleteUser(BankUser u);
	
	//-----------------Checking-------------------
	
	public List<BankChecking> getAllChecking();
	public BankChecking getCheckingById(int id);
	public BankChecking getCheckingByUserId(int id); 
	public void insertChecking(BankChecking u);	
	public void updateChecking(BankChecking u);
	
	//-----------------Saving-------------------

	public List<BankSaving> getAllSaving();
	public BankSaving getSavingById(int id);
	public BankSaving getSavingByUser(int id);
	public void insertSaving(BankSaving u);	
	public void updateSaving(BankSaving u);
	
	//-----------------JoinAccount-------------------
	
	public List<JoinAccount> getAllJoinAccount();
	public JoinAccount getJoinAccountById(int id);
	public JoinAccount getJoinAccountByLastEntry();
	public void insertJoinAccount(JoinAccount u);	
	public void updateJoinAccount(JoinAccount u);
	
	//-----------------JoinUser-------------------
	public List<JoinUser> getAllJoinUser();
	public JoinUser getJoinUserById(int id);
	public JoinUser getJoinUserByUser(int id);
	public void insertJoinUser(JoinUser u);	
	public void updateJoinUser(JoinUser u);
	
	
}
