package com.revature;

import com.revature.model.BankUser;
import com.revature.model.BankChecking;
import com.revature.service.BankUserService;
import com.revature.model.BankSaving;
import com.revature.model.JoinAccount;
import com.revature.model.JoinUser;

public class BankDriver {
	public static void main(String[] args) {
		
		
		BankUserService us = new BankUserService();
		
/*		
		BankUser u;		
		System.out.println("---------getAllUser()---------");
		System.out.println(us.getAllUsers());
		System.out.println("------------------------------");

		System.out.println("---------GetUser()---------");
		System.out.println(us.GetUser(1));
		System.out.println("------------------------------");
		

		System.out.println("---------insertUser()---------");
		u=new BankUser(0, "Young", "Boxer",true,false,false);
		us.insertUser(u);
		System.out.println(us.getAllUsers());
		System.out.println("------------------------------");
		
		System.out.println("---------UpdateUser()---------");
		u=new BankUser(9, "OLD", "Boxer",true,false,false);
		us.ChangeUser(u);
		System.out.println(us.getAllUsers());
		System.out.println("------------------------------");

		
		System.out.println("---------DeleteUser()---------");
		us.removeUser(9);
		System.out.println(us.getAllUsers());
		System.out.println("------------------------------");

		
		BankChecking u;		
		System.out.println("---------getAllChecking()---------");
		System.out.println(us.getAllChecking());
		System.out.println("------------------------------");
		
		System.out.println("---------GetChecking()---------");
		System.out.println(us.GetChecking(1));
		System.out.println("------------------------------");
		
		System.out.println("---------insertUser()---------");
		u=new BankChecking(0, 45,231.55);
		us.insertChecking(u);
		System.out.println(us.getAllChecking());
		System.out.println("------------------------------");
		
		System.out.println("---------UpdateChecking()---------");
		u=new BankChecking(4,69,2001.78);
		us.ChangeChecking(u);
		System.out.println(us.getAllChecking());
		System.out.println("------------------------------");
		
		
		
		BankSaving u;		
		System.out.println("---------getAllSaving()---------");
		System.out.println(us.getAllSaving());
		System.out.println("------------------------------");
		
		System.out.println("---------GetSaving()---------");
		System.out.println(us.GetSaving(1));
		System.out.println("------------------------------");
		
		System.out.println("---------insertSaving()---------");
		u=new BankSaving(0, 1,231.55);
		us.insertSaving(u);
		System.out.println(us.getAllSaving());
		System.out.println("------------------------------");
		
		System.out.println("---------UpdateSaving()---------");
		u=new BankSaving(4,2,2001.78);
		us.ChangeSaving(u);
		System.out.println(us.getAllChecking());
		System.out.println("------------------------------");
		
		
		JoinAccount u;		
		System.out.println("---------getAllJoinAccount()---------");
		System.out.println(us.getAllJoinAccount());
		System.out.println("------------------------------");
		
		System.out.println("---------GetJoinAccount()---------");
		System.out.println(us.GetJoinAccount(1));
		System.out.println("------------------------------");
		
		System.out.println("---------insertJoinAccount()---------");
		u=new JoinAccount(0,231.55);
		us.insertJoinAccount(u);
		System.out.println(us.getAllJoinAccount());
		System.out.println("------------------------------");
		
		System.out.println("---------UpdateJoinAccount()---------");
		u=new JoinAccount(4,2001.78);
		us.ChangeJoinAccount(u);
		System.out.println(us.getAllJoinAccount());
		System.out.println("------------------------------");
		


			
		System.out.println("---------getAllJoinUser()---------");
		System.out.println(us.getAllJoinUser());
		System.out.println("------------------------------");
		
		System.out.println("---------GetJoinUser()---------");
		System.out.println(us.GetJoinUser(1));
		System.out.println("------------------------------");
*/		
		JoinUser u;	
		System.out.println("---------insertJoinUser()---------");
		u=new JoinUser(0,2,1);
		us.insertJoinUser(u);
		System.out.println(us.getAllJoinUser());
		System.out.println("------------------------------");
		
		System.out.println("---------UpdateJoinUser()---------");
		u=new JoinUser(2,2,3);
		us.ChangeJoinUser(u);
		System.out.println(us.getAllJoinUser());
		System.out.println("------------------------------");
		
	}
}
