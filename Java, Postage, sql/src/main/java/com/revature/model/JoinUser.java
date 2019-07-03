package com.revature.model;

public class JoinUser {
	private int id;
	private int user_id;
	private int join_id;
	
	public JoinUser() {
		super();
	}
	
	public JoinUser(int id, int user_id,int join_id) {
		super();
		this.id=id;
		this.user_id=user_id;
		this.join_id=join_id;				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getJoin_id() {
		return join_id;
	}

	public void setJoin_id(int join_id) {
		this.join_id = join_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + join_id;
		result = prime * result + user_id;
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
		JoinUser other = (JoinUser) obj;
		if (id != other.id)
			return false;
		if (join_id != other.join_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinUser [id=" + id + ", user_id=" + user_id + ", join_id=" + join_id + "]\n";
	}
	
	
	

}
