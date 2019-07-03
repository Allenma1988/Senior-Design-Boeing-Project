package com.revature.service;

import java.util.List;

import com.revature.model.BankUser;
import com.revature.model.BankChecking;
import com.revature.model.BankSaving;
import com.revature.model.JoinAccount;
import com.revature.model.JoinUser;
import com.revature.repository.PostgreSQLlmi_Bank;

/*
 * This is the service layer of our application. This is where
 * any business logic should be placed.
 */

public class BankUserService {
	
	public List<BankUser> getAllUsers(){
		return new PostgreSQLlmi_Bank().getAllUsers();
	}
	public BankUser GetUser(int i) {
		return new PostgreSQLlmi_Bank().getUserById(i);
	}
	public BankUser GetUser(String UserName) {
		return new PostgreSQLlmi_Bank().getUserByUserName(UserName);
	}
	
	public void insertUser(BankUser u) {
		new PostgreSQLlmi_Bank().insertUser(u);
	}
	
	public void ChangeUser(BankUser u) {
		new PostgreSQLlmi_Bank().updateUser(u);
	}
	
	public void removeUser(int i) {
		new PostgreSQLlmi_Bank().deleteUser(GetUser(i));
	}
	
	//------------------------checking--------------------------
	
	public List<BankChecking> getAllChecking(){
		return new PostgreSQLlmi_Bank().getAllChecking();
	}
	
	public BankChecking GetChecking(int i) {
		return new PostgreSQLlmi_Bank().getCheckingById(i);
	}
	public BankChecking GetCheckingByUser(int id) {
		return new PostgreSQLlmi_Bank().getCheckingByUserId(id);
	}

	public void insertChecking(BankChecking u) {
		new PostgreSQLlmi_Bank().insertChecking(u);
	}
	
	public void ChangeChecking(BankChecking u) {
		new PostgreSQLlmi_Bank().updateChecking(u);
	}
	
	//------------------------saving--------------------------
	
	public List<BankSaving> getAllSaving(){
		return new PostgreSQLlmi_Bank().getAllSaving();
	}
	
	public BankSaving GetSaving(int i) {
		return new PostgreSQLlmi_Bank().getSavingById(i);
	}
	
	public BankSaving GetSavingbyUser(int id) {
		return new PostgreSQLlmi_Bank().getSavingByUser(id);
	}

	public void insertSaving(BankSaving u) {
		new PostgreSQLlmi_Bank().insertSaving(u);
	}
	
	public void ChangeSaving(BankSaving u) {
		new PostgreSQLlmi_Bank().updateSaving(u);
	}
	

	//------------------------JoinAccount--------------------------
	public List<JoinAccount> getAllJoinAccount(){
		return new PostgreSQLlmi_Bank().getAllJoinAccount();
	}
	
	public JoinAccount GetJoinAccount(int i) {
		return new PostgreSQLlmi_Bank().getJoinAccountById(i);
	}
	
	public JoinAccount GetJoinAccountByLastEntry() {
		return new PostgreSQLlmi_Bank().getJoinAccountByLastEntry();
	}

	public void insertJoinAccount(JoinAccount u) {
		new PostgreSQLlmi_Bank().insertJoinAccount(u);
	}
	
	public void ChangeJoinAccount(JoinAccount u) {
		new PostgreSQLlmi_Bank().updateJoinAccount(u);
	}

	//------------------------JoinUser--------------------------
	public List<JoinUser> getAllJoinUser(){
		return new PostgreSQLlmi_Bank().getAllJoinUser();
	}
	
	public JoinUser GetJoinUser(int i) {
		return new PostgreSQLlmi_Bank().getJoinUserById(i);
	}
	public JoinUser GetJoinUserbyUser(int id) {
		return new PostgreSQLlmi_Bank().getJoinUserByUser(id);
	}

	public void insertJoinUser(JoinUser u) {
		new PostgreSQLlmi_Bank().insertJoinUser(u);
	}
	
	public void ChangeJoinUser(JoinUser u) {
		new PostgreSQLlmi_Bank().updateJoinUser(u);
	}

}
