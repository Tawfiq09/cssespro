package com.csse.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getconnection() throws ClassNotFoundException {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/cssemyoriginal";
		String userName = "root";
		String password = "sagarox";
		Class.forName(driver);
		try {
			Connection connection = DriverManager.getConnection(url, userName, password);

			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println(e);
		}
		return null;
	}
}
