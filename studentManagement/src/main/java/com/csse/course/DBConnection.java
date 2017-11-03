package com.csse.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection = null;
	public static Connection getconnection() throws ClassNotFoundException {

		if(connection == null) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/csse";
		String userName = "root";
		String password = "";
		Class.forName(driver);
		try {
			 connection = DriverManager.getConnection(url, userName, password);

			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println(e);
		}
		}
		
			return connection;
		
		
	}
}
