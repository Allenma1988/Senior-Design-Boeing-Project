package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/*
	 * I only need once instance of a connection for this application.
	 */
	private static Connection conn;
	
	public static Connection getConnection() {
		
		try {
			if(conn == null || conn.isClosed()) {
				try {
					/*
					 * Hardcoding your url, username, and password into the application
					 * is bad practice (primarily for security reasons). We can instead
					 * use environment variables to obscure our login credentials.
					 */
					Class.forName("org.postgresql.Driver");
					conn = DriverManager.getConnection(System.getenv("dburl"), System.getenv("dbusername"), System.getenv("dbpassword"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
