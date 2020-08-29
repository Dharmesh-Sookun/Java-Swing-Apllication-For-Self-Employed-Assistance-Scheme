package com.example.mra_seas;

import java.sql.*;

public class DatabaseConnection {
	
	private static Connection conn = null;
	private static String databaseURl = "jdbc:mysql://localhost:3306/mra_seas?useSSL=false";
	private static String username = "root";
	private static String password = "@yahoo.com";
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURl, username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	


}
