package com.revature.repository;
/*
 * class example
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class PostgreSQLImpl implements UserRepository {


	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		/*
		 * When working with JDBC, there are several interfaces
		 * and classes that we use to facilitate a connection
		 * to our database, query our database, and hold the 
		 * retrieved records.
		 * 
		 * Our Connection interface provides the means for actually
		 * connecting to our database.
		 * 
		 * Our Statement interface is used to prepare statements that
		 * we will execute.
		 * 
		 * Our ResultSet interface is used to store the records we retrieve from
		 * our database.
		 */
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
		conn = ConnectionFactory.getConnection();
		final String SQL = "SELECT * FROM users";
		stmt = conn.createStatement();
		set = stmt.executeQuery(SQL);
		
		while(set.next()) {
			users.add(new User(
					set.getInt(1),
					set.getString(2),
					set.getString(3))
					);
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


	public User getUserById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		User u = null;
		final String SQL = "SELECT * FROM users WHERE users_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			while(set.next()) {
				u = new User(
						set.getInt(1),
						set.getString(2),
						set.getString(3)
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


	public void insertUser(User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		/*
		 * We don't want to directly put the values we'll input int our
		 * database here. We'll instead parameterize our query and use
		 * a prepared statement. Prepared Statements pre-compile our
		 * queries and allow us to protect against SQL injection.
		 */
		final String SQL = "INSERT INTO users VALUES(default, ?, ?)";
		
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
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}

	}


	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "DELETE FROM users WHERE users_id = ?";
		
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

	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}


}
