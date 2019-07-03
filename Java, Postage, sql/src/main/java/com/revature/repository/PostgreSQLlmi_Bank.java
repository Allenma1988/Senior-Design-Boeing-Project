package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.BankUser;
import com.revature.model.BankChecking;
import com.revature.model.BankSaving;
import com.revature.model.JoinAccount;
import com.revature.model.JoinUser;

import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class PostgreSQLlmi_Bank implements BankUserRepository{

	public List<BankUser> getAllUsers() {
		List<BankUser> users = new ArrayList<BankUser>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			final String SQL = "SELECT * FROM public.banking_user";
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				users.add(new BankUser(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getBoolean(4),
						set.getBoolean(5),
						set.getBoolean(6)
						));
			}
			/*
			 * The SQLException is an exception that is specific to JDBC.
			 */
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//Close your connection, statement, and result set
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
				ConnectionClosers.closeResultSet(set);
			}
			return users;
	}
	

	public BankUser getUserById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		BankUser u = null;
		final String SQL = "SELECT * FROM public.banking_user WHERE user_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new BankUser(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getBoolean(4),
						set.getBoolean(5),
						set.getBoolean(6)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return u;
	}
	
	public BankUser getUserByUserName(String userName) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		BankUser u = null;
		final String SQL = "SELECT * FROM public.banking_user WHERE username = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, userName);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new BankUser(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getBoolean(4),
						set.getBoolean(5),
						set.getBoolean(6)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return u;
	}
	
	public void insertUser(BankUser u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		/*
		 * We don't want to directly put the values we'll input int our
		 * database here. We'll instead parameterize our query and use
		 * a prepared statement. Prepared Statements pre-compile our
		 * queries and allow us to protect against SQL injection.
		 */
		final String SQL = "INSERT INTO public.banking_user VALUES(default, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			/*
			 * We'll be using a Prepared Statement. A Prepared Statement
			 * is a special statement that protects against SQL injection.
			 */
			stmt = conn.prepareStatement(SQL);
			/*
			 * Here we're telling JDBC to attach the value that
			 * u.getName() returns to question mark 1 and to attach
			 * the value that u.getPassword() returns to question mark 2.
			 */
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPassword());
			stmt.setBoolean(3, u.isChecking());
			stmt.setBoolean(4, u.isSaving());
			stmt.setBoolean(5, u.isJoinAccount());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}
	

		public void updateUser(BankUser u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE public.banking_user SET username=?,pass=?,checking=?,saving=?,joinAccount=? WHERE user_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPassword());
			stmt.setBoolean(3, u.isChecking());
			stmt.setBoolean(4, u.isSaving());
			stmt.setBoolean(5, u.isJoinAccount());
			stmt.setInt(6, u.getId());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}
	
	
//do not use
	public void deleteUser(BankUser u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "DELETE FROM public.banking_user WHERE user_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, u.getId());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}


//-----------------------------------------------checking--------------------
	

	public List<BankChecking> getAllChecking() {
		List<BankChecking> users = new ArrayList<BankChecking>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			final String SQL = "SELECT * FROM public.banking_checking";
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				users.add(new BankChecking(
						set.getInt(1),
						set.getInt(2),
						set.getDouble(3)
						));
			}
			/*
			 * The SQLException is an exception that is specific to JDBC.
			 */
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//Close your connection, statement, and result set
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
				ConnectionClosers.closeResultSet(set);
			}
			return users;
	}
	
	public BankChecking getCheckingById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		BankChecking u = null;
		final String SQL = "SELECT * FROM public.banking_checking WHERE checking_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new BankChecking(
						set.getInt(1),
						set.getInt(2),
						set.getDouble(3)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}

		return u;
	}
	public BankChecking getCheckingByUserId(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		BankChecking u = null;
		final String SQL = "SELECT * FROM public.banking_checking WHERE user_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new BankChecking(
						set.getInt(1),
						set.getInt(2),
						set.getDouble(3)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}

		return u;
	}

	public void insertChecking(BankChecking u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		/*
		 * We don't want to directly put the values we'll input int our
		 * database here. We'll instead parameterize our query and use
		 * a prepared statement. Prepared Statements pre-compile our
		 * queries and allow us to protect against SQL injection.
		 */
		final String SQL = "INSERT INTO public.banking_checking VALUES(default, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			/*
			 * We'll be using a Prepared Statement. A Prepared Statement
			 * is a special statement that protects against SQL injection.
			 */
			stmt = conn.prepareStatement(SQL);
			/*
			 * Here we're telling JDBC to attach the value that
			 * u.getName() returns to question mark 1 and to attach
			 * the value that u.getPassword() returns to question mark 2.
			 */
			stmt.setInt(1, u.getUserId());
			stmt.setDouble(2, u.getBalance());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}
	
	public void updateChecking(BankChecking u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE public.banking_checking SET user_id=?,balance=? WHERE checking_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, u.getUserId());
			stmt.setDouble(2, u.getBalance());
			stmt.setInt(3, u.getId());
	
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}
	
	//-----------------------------------------------saving--------------------

	public List<BankSaving> getAllSaving() {
		List<BankSaving> users = new ArrayList<BankSaving>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			final String SQL = "SELECT * FROM public.banking_saving";
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				users.add(new BankSaving(
						set.getInt(1),
						set.getInt(2),
						set.getDouble(3)
						));
			}
			/*
			 * The SQLException is an exception that is specific to JDBC.
			 */
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//Close your connection, statement, and result set
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
				ConnectionClosers.closeResultSet(set);
			}
			return users;
	}
	
	public BankSaving getSavingById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		BankSaving u = null;
		final String SQL = "SELECT * FROM public.banking_saving WHERE saving_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new BankSaving(
						set.getInt(1),
						set.getInt(2),
						set.getDouble(3)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return u;
	}
	public BankSaving getSavingByUser(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		BankSaving u = null;
		final String SQL = "SELECT * FROM public.banking_saving WHERE user_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new BankSaving(
						set.getInt(1),
						set.getInt(2),
						set.getDouble(3)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}
		return u;
	}

	public void insertSaving(BankSaving u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		/*
		 * We don't want to directly put the values we'll input int our
		 * database here. We'll instead parameterize our query and use
		 * a prepared statement. Prepared Statements pre-compile our
		 * queries and allow us to protect against SQL injection.
		 */
		final String SQL = "INSERT INTO public.banking_saving VALUES(default, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			/*
			 * We'll be using a Prepared Statement. A Prepared Statement
			 * is a special statement that protects against SQL injection.
			 */
			stmt = conn.prepareStatement(SQL);
			/*
			 * Here we're telling JDBC to attach the value that
			 * u.getName() returns to question mark 1 and to attach
			 * the value that u.getPassword() returns to question mark 2.
			 */
			stmt.setInt(1, u.getUserId());
			stmt.setDouble(2, u.getBalance());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}
	
	public void updateSaving(BankSaving u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE public.banking_saving SET user_id=?,balance=? WHERE saving_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, u.getUserId());
			stmt.setDouble(2, u.getBalance());
			stmt.setInt(3, u.getId());
	
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}
	
	//-----------------------------------------------JoinAccount--------------------
	public List<JoinAccount> getAllJoinAccount() {
		List<JoinAccount> users = new ArrayList<JoinAccount>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			final String SQL = "SELECT * FROM public.banking_joinAccount";
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				users.add(new JoinAccount(
						set.getInt(1),
						set.getDouble(2)
						));
			}
			/*
			 * The SQLException is an exception that is specific to JDBC.
			 */
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//Close your connection, statement, and result set
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
				ConnectionClosers.closeResultSet(set);
			}
			return users;
	}
	
	public JoinAccount getJoinAccountById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		JoinAccount u = null;
		final String SQL = "SELECT * FROM public.banking_joinAccount WHERE join_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new JoinAccount(
						set.getInt(1),
						set.getDouble(2)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}

		return u;
	}
	
	public JoinAccount getJoinAccountByLastEntry() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		JoinAccount u = null;
		//final String SQL = "SELECT TOP 1 * FROM public.banking_joinAccount ORDER by join_id DESC";
		final String SQL = "SELECT * FROM public.banking_joinAccount WHERE join_id = (SELECT MAX(join_id) FROM public.banking_joinAccount)";
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			//stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new JoinAccount(
						set.getInt(1),
						set.getDouble(2)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}

		return u;
	}

	public void insertJoinAccount(JoinAccount u) {
		System.out.println("__________insertJoinAccount__________");
		Connection conn = null;
		PreparedStatement stmt = null;
		/*
		 * We don't want to directly put the values we'll input int our
		 * database here. We'll instead parameterize our query and use
		 * a prepared statement. Prepared Statements pre-compile our
		 * queries and allow us to protect against SQL injection.
		 */
		final String SQL = "INSERT INTO public.banking_joinAccount VALUES(default, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			/*
			 * We'll be using a Prepared Statement. A Prepared Statement
			 * is a special statement that protects against SQL injection.
			 */
			stmt = conn.prepareStatement(SQL);
			/*
			 * Here we're telling JDBC to attach the value that
			 * u.getName() returns to question mark 1 and to attach
			 * the value that u.getPassword() returns to question mark 2.
			 */
			stmt.setDouble(1, u.getBalance());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		System.out.println("__________insertJoinAccount_end__________");

	}
	
	public void updateJoinAccount(JoinAccount u) {
		System.out.println("__________updateJoinAccount__________");
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE public.banking_joinAccount SET balance=? WHERE join_id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setDouble(1, u.getBalance());
			stmt.setInt(2, u.getId());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		System.out.println("__________updateJoinAccount_end__________");
	}
	
	//-----------------------------------------------JoinUser--------------------
	public List<JoinUser> getAllJoinUser() {
		List<JoinUser> users = new ArrayList<JoinUser>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			final String SQL = "SELECT * FROM public.banking_joinUser";
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				users.add(new JoinUser(
						set.getInt(1),
						set.getInt(2),
						set.getInt(3)
						));
			}
			/*
			 * The SQLException is an exception that is specific to JDBC.
			 */
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//Close your connection, statement, and result set
				ConnectionClosers.closeConnection(conn);
				ConnectionClosers.closeStatement(stmt);
				ConnectionClosers.closeResultSet(set);
			}
			return users;
	}
	
	public JoinUser getJoinUserById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		JoinUser u = null;
		final String SQL = "SELECT * FROM public.banking_joinUser WHERE id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new JoinUser(
						set.getInt(1),
						set.getInt(2),
						set.getInt(3)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}

		return u;
	}
	
	public JoinUser getJoinUserByUser(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		JoinUser u = null;
		final String SQL = "SELECT * FROM public.banking_joinUser WHERE user_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new JoinUser(
						set.getInt(1),
						set.getInt(2),
						set.getInt(3)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
			ConnectionClosers.closeResultSet(set);
		}

		return u;
	}

	public void insertJoinUser(JoinUser u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		/*
		 * We don't want to directly put the values we'll input int our
		 * database here. We'll instead parameterize our query and use
		 * a prepared statement. Prepared Statements pre-compile our
		 * queries and allow us to protect against SQL injection.
		 */
		final String SQL = "INSERT INTO public.banking_joinUser VALUES(default, ?,?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			/*
			 * We'll be using a Prepared Statement. A Prepared Statement
			 * is a special statement that protects against SQL injection.
			 */
			stmt = conn.prepareStatement(SQL);
			/*
			 * Here we're telling JDBC to attach the value that
			 * u.getName() returns to question mark 1 and to attach
			 * the value that u.getPassword() returns to question mark 2.
			 */
			stmt.setInt(1, u.getUser_id());
			stmt.setInt(2, u.getJoin_id());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}
	
	public void updateJoinUser(JoinUser u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "UPDATE public.banking_joinUser SET user_id=?,join_id=? WHERE id=?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, u.getUser_id());
			stmt.setInt(2, u.getJoin_id());
			stmt.setInt(3, u.getId());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}
	

}
