package com.revature.model;

public class BankUser {
	
	/*
	 * alt + s to load all the geter, seter, hashcode, to string. etc
	 */
	
	private int id;
	private String name;
	private String password;
	private boolean checking;
	private boolean saving;
	private boolean joinAccount;
	
	public BankUser() {
		super();
	}
	public BankUser(int id, String name, String password, boolean checking, boolean saving, boolean joinAccount) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.checking=checking;
		this.saving=saving;
		this.joinAccount=joinAccount;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isChecking() {
		return checking;
	}

	public void setChecking(boolean checking) {
		this.checking = checking;
	}

	public boolean isSaving() {
		return saving;
	}

	public void setSaving(boolean saving) {
		this.saving = saving;
	}

	public boolean isJoinAccount() {
		return joinAccount;
	}

	public void setJoinAccount(boolean joinAccount) {
		this.joinAccount = joinAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (checking ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (joinAccount ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (saving ? 1231 : 1237);
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
		BankUser other = (BankUser) obj;
		if (checking != other.checking)
			return false;
		if (id != other.id)
			return false;
		if (joinAccount != other.joinAccount)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (saving != other.saving)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankUser [id=" + id + ", name=" + name + ", password=" + password + ", checking=" + checking
				+ ", saving=" + saving + ", joinAccount=" + joinAccount + "]\n";
	}
	
	
	

}
