package com.revature;


import com.revature.model.BankUser;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.model.BankChecking;
import com.revature.service.BankUserService;
import com.revature.model.BankSaving;
import com.revature.model.JoinAccount;
import com.revature.model.JoinUser;


public class BankUI {
	private BankUserService us=new BankUserService();
	private BankUser u=new BankUser();
	private BankChecking c=new BankChecking();
	private BankSaving s=new BankSaving();
	private JoinAccount a=new JoinAccount();
	private JoinUser j=new JoinUser();	
	
public BankUI() {
	super();
}
	
	
	
	public void TheBank() {
			
		
		Welcome();
		
		if(Log_or_create()==false) {
			u=createAccount();
		}
		else {
			do {
				u=LogIn();	
			}while (u==null);
			
		}
			
		
		while (Menu()) {
			}
		
	}
	
	
	public void Welcome() {
		System.out.flush();
		System.out.println("------------------------Welcome------------------------");
		System.out.println("Wecome to Allen's Bank!");
		System.out.println("Where the bank dont steal from the customer. ");
		System.out.println("...most of the time");
		System.out.println("------------------------Welcome------------------------");
		
	}
	
	public boolean Menu() {
		boolean boolMenu=true;
				
		System.out.println("------------------------Menu------------------------");
		System.out.println("0: exit ");
		System.out.println("1:  see all user table");
		System.out.println("2:  see all user account");
		System.out.println("3:  Change your user name or password ");
		System.out.println("4:  Active your checking account ");
		System.out.println("5:  Create your checking account ");
		System.out.println("6:  See your checking account ");
		System.out.println("7:  Update your balance in your checking account");
		System.out.println("8:  Active your Saving account ");
		System.out.println("9:  Create your Saving account ");
		System.out.println("10: See your Saving account ");
		System.out.println("11: Update your balance in your Saving account");
		System.out.println("12: Active your Join Account ");
		System.out.println("13: Create your Join account ");
		System.out.println("14: See your Join account ");
		System.out.println("15: Update your balance in your Join account");
		System.out.println("16: Deactive your Checking account");
		System.out.println("17: Deactive your Saving account");
		System.out.println("18: Deactive your Join account");
		System.out.println("19: See everyone Checking account");
		System.out.println("20: See everyone  Saving account");
		System.out.println("21: See everyone  Join account");
		
		System.out.println("Input a choice");
		System.out.println("------------------------Menu------------------------");
		
		switch (inputInt()) {
		case 0: boolMenu=false;
				break;
		case 1:	System.out.println(us.getAllUsers());
				break;	
		case 2:	System.out.println(u);
				break;	
		case 3:	u=ChangeAccount(u);
				break;	
		case 4:	u=ActiveChecking(u);
				break;	
		case 5:	c=CreateChecking(u);
				break;	
		case 6:	System.out.println(c);
				break;
		case 7:	c=UpdateChecking(c);
				break;
		case 8:	u=ActiveSaving(u);
				break;	
		case 9:	s=CreateSaving(u);
				break;	
		case 10:System.out.println(s);
				break;
		case 11:s=UpdateSaving(s);
				break;
		case 12:u=ActiveJoinAccount(u);
				break;	
		case 13:{
			a=CreateJoinAccount(u);
			j=CreateJoinUser(u,a);
		}
				break;	
		case 14:System.out.println(a);
				break;
		case 15:a=UpdateJoinAccount(a);
				break;
		case 16:u=DeactiveChecking(u);
				break;
		case 17:u=DeactiveSaving(u);
				break;
		case 18:u=DeactiveJoinAccount(u);
				break;
		case 19:System.out.println(us.getAllChecking());
				break;
		case 20:System.out.println(us.getAllSaving());
				break;
		case 21:System.out.println(us.getAllJoinAccount());
				break;
		default:System.out.println("-------Your choice is not in the list.-------");
        		break;
    }		
		return boolMenu;
	}
	
	
	
	
	
	
	
	
	
	//input int, if not int, it loop
	public int inputInt() {
		int theInt = 0;
		boolean reset;		
		do {
			try
			{
				System.out.println("------------------------inputInt------------------------");
				reset=false;
				Scanner myObj= new Scanner(System.in);
				theInt=myObj.nextInt();
			} catch(InputMismatchException ex)
			{
				System.out.println("------------------------inputInt------------------------");
				reset=true;
			}			
		}while(reset==true);		
		return theInt;
	}
	
	//input double, if not double, it loop
		public double inputDouble() {
			double theDouble = 0.00;
			boolean reset;		
			
			
			
			do {
				do {
				try
				{
					reset=false;
					Scanner myObj= new Scanner(System.in);
					theDouble=myObj.nextDouble();
				} catch(InputMismatchException ex)
				{
					reset=true;
				}			
			}while(reset==true);	
			}while(theDouble<=-10000000||theDouble>=10000000);
			
			
			
			return theDouble;
		}
		
		//input string, if not String, it loop
		public String inputString() {
			String theString = null;
			boolean reset;		
			do {
				try
				{
					reset=false;
					Scanner myObj= new Scanner(System.in);
					theString=myObj.nextLine();
				} catch(InputMismatchException ex)
				{
					reset=true;
				}			
			}while(reset==true);		
			return theString;
		}
		//create=false, login=true
		public boolean Log_or_create() {
			boolean or = false;
			System.out.flush();
			System.out.println("------------------------Log_or_create------------------------");
			System.out.println("enter 1 to create a new user");
			System.out.println("Enter 2 to Log In");
			System.out.println("Anything else exit");
			System.out.println("------------------------Log_or_create------------------------");
			int ans=inputInt();
			if(ans==1) {
				or=false;
			}
			else if(ans==2) {
				or=true;
			}
			else {
				System.out.println("------------------------Good Bye------------------------");
				System.exit(0);
			}
				
			
			
			return or;
		}
	
		
		public BankUser createAccount() {
			System.out.flush();
			System.out.println("------------------------createAccount------------------------");
			System.out.println("Enter a new user");
			String username=inputString();
			System.out.println("Enter a new password");
			String password=inputString();
			System.out.println("------------------------createAccount------------------------");
			BankUserService us=new BankUserService();
			BankUser u=new BankUser(0,username,password,false,false,false);		
			us.insertUser(u);
			return us.GetUser(username);
		}
		
		public BankUser LogIn() {
			//need to loop until user and pass are correct....
			System.out.flush();
			System.out.println("------------------------LogIn------------------------");
			System.out.println("Enter your user");
			String username=inputString();
			System.out.println("Enter your password");
			String password=inputString();
			System.out.println("------------------------LogIn------------------------");
			BankUserService us=new BankUserService();			
			
			//need to get password system check
			return us.GetUser(username);			
		}
		//change user's username and password
		public BankUser ChangeAccount(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------ChangeAccount------------------------");
			System.out.println("Enter a new user");
			String username=inputString();
			System.out.println("Enter a new password");
			String password=inputString();
			System.out.println("------------------------ChangeAccount------------------------");
			BankUserService us=new BankUserService();
			BankUser u=new BankUser(cu.getId(),username,password,cu.isChecking(),cu.isSaving(),cu.isJoinAccount());		
			us.ChangeUser(u);
			return us.GetUser(cu.getId());
		}
		
		public BankUser ActiveChecking(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------ActiveChecking------------------------");
			BankUserService us=new BankUserService();
			cu.setChecking(true);
			us.ChangeUser(cu);
			return us.GetUser(cu.getId());
		}
		public BankUser DeactiveChecking(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------DeactiveChecking------------------------");
			BankUserService us=new BankUserService();
			cu.setChecking(false);
			us.ChangeUser(cu);
			return us.GetUser(cu.getId());
		}
		
		public BankUser ActiveSaving(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------ActiveSaving------------------------");
			BankUserService us=new BankUserService();
			cu.setSaving(true);
			us.ChangeUser(cu);
			return us.GetUser(cu.getId());
		}
		public BankUser DeactiveSaving(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------DeactiveSaving------------------------");
			BankUserService us=new BankUserService();
			cu.setSaving(false);
			us.ChangeUser(cu);
			return us.GetUser(cu.getId());
		}
		public BankUser ActiveJoinAccount(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------ActiveJoinAccount------------------------");
			BankUserService us=new BankUserService();
			cu.setJoinAccount(true);
			us.ChangeUser(cu);
			return us.GetUser(cu.getId());
		}
		public BankUser DeactiveJoinAccount(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------DeactiveJoinAccount------------------------");
			BankUserService us=new BankUserService();
			cu.setJoinAccount(false);
			us.ChangeUser(cu);
			return us.GetUser(cu.getId());
		}
		
		public BankChecking CreateChecking(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------CreateChecking------------------------");
			System.out.println("Enter a new balance for checking account.");
			double newBalance=inputDouble();
			System.out.println("------------------------CreateChecking------------------------");
			BankUserService us=new BankUserService();
			BankChecking checking=new BankChecking(0,cu.getId(),newBalance);
			us.insertChecking(checking);
			return us.GetCheckingByUser(cu.getId());
		}
		
		
		public BankChecking UpdateChecking(BankChecking cu) {
			System.out.flush();
			System.out.println("------------------------UpdateChecking------------------------");
			System.out.println("Enter a new balance for checking account.");
			double newBalance=inputDouble();
			System.out.println("------------------------UpdateChecking------------------------");
			BankUserService us=new BankUserService();
			cu.setBalance(newBalance);
			us.ChangeChecking(cu);			
			return us.GetChecking(cu.getId());
		}
		
		public BankSaving CreateSaving(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------CreateSaving------------------------");
			System.out.println("Enter a new balance for Saving account.");
			double newBalance=inputDouble();
			System.out.println("------------------------CreateSaving------------------------");
			BankUserService us=new BankUserService();
			BankSaving Saving=new BankSaving(0,cu.getId(),newBalance);
			us.insertSaving(Saving);
			return us.GetSavingbyUser(cu.getId());
		}
		
		public BankSaving UpdateSaving(BankSaving cu) {
			System.out.flush();
			System.out.println("------------------------UpdateSaving------------------------");
			System.out.println("Enter a new balance for Saving account.");
			double newBalance=inputDouble();
			System.out.println("------------------------UpdateSaving------------------------");
			BankUserService us=new BankUserService();
			cu.setBalance(newBalance);
			us.ChangeSaving(cu);			
			return us.GetSaving(cu.getId());
		}
		
		public JoinAccount CreateJoinAccount(BankUser cu) {
			System.out.flush();
			System.out.println("------------------------CreateJoinAccount------------------------");
			System.out.println("Enter a new balance for Join account.");
			double newBalance=inputDouble();
			System.out.println("------------------------CreateJoinAccount------------------------");
			BankUserService us=new BankUserService();
			JoinAccount Join=new JoinAccount(0,newBalance);
			us.insertJoinAccount(Join);
			System.out.println("------------------------GetJoinAccountByLastEntry= "+us.GetJoinAccountByLastEntry());
			return us.GetJoinAccountByLastEntry();
		}
		
		public JoinAccount UpdateJoinAccount(JoinAccount cu) {
			System.out.flush();
			System.out.println("------------------------UpdateJoinAccount------------------------");
			System.out.println("Enter a new balance for Join account.");
			double newBalance=inputDouble();
			System.out.println("------------------------UpdateJoinAccount------------------------");
			BankUserService us=new BankUserService();
			cu.setBalance(newBalance);
			us.ChangeJoinAccount(cu);			
			return us.GetJoinAccount(cu.getId());
		}
		
		public JoinUser CreateJoinUser(BankUser cu, JoinAccount ca) {
			System.out.flush();
			System.out.println("------------------------CreateJoinUser------------------------");

			BankUserService us=new BankUserService();
			JoinUser User=new JoinUser(0,cu.getId(),ca.getId());
			us.insertJoinUser(User);
			return us.GetJoinUserbyUser(cu.getId());
		}
		
		

		
		
		
		
		
		

	
	
	

}
