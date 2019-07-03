package com.revature.model;

public class BankSaving {
	/*
	 * alt + s to load all the geter, seter, hashcode, to string. etc
	 */
	private int id;
	private int userId;
	private double balance;
	
	
	public BankSaving() {
		super();
	}
	
	public BankSaving(int id, int userId, double balance) {
		super();
		this.id=id;
		this.userId=userId;
		this.balance=balance;				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankSaving other = (BankSaving) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankSaving [id=" + id + ", userId=" + userId + ", balance=" + balance + "]\n";
	}
	
	
	
	

}
