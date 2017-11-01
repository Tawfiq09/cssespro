package com.csse.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	public static void setconnection() {

		if (connection == null) {
			try {
				connection = DBConnection.getconnection();
				System.out.println("connected");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// method for get all faculty details from database
	public static ResultSet fillFaculty() {
		String query = "select * from faculty";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static ResultSet fillSpecialication(String faculty, int year) {
		String query = " select * from specialication where faculty = ? and year= ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, faculty);
			preparedStatement.setInt(2, year);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static ResultSet fillSCourseFee(String faculty, int year, String specialication) {
		String query = " select * from specialication where faculty = ? and year= ? and specialication=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, faculty);
			preparedStatement.setInt(2, year);
			preparedStatement.setString(3, specialication);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static ResultSet getExaminationDetails(String faculty, int year_of_university, String specialization,
			int semester, int year) {

		String query = "select * from exams where faculty=? and year_of_university =? and specialization=? and semester=? and YEAR(date_of_exam) =?  ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, faculty);
			preparedStatement.setInt(2, year_of_university);
			preparedStatement.setString(3, specialization);
			preparedStatement.setInt(4, semester);
			preparedStatement.setInt(5, year);

			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet getExaminationDetails(int year, String faculty) {

		String query = "select * from exams where faculty=? and YEAR(date_of_exam) =?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, faculty);
			preparedStatement.setInt(2, year);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
