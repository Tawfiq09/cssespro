package com.csse.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

	// this class provide support services for both exam payment and semester
	// payment classes
	private static Connection connection = null;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	// to get sql connection
	public static void setconnection() throws ClassNotFoundException {

		if (connection == null) {

			connection = DBConnection.getconnection();

		}
	}

	// method for get all faculty details from database
	public static ResultSet fillFaculty() throws SQLException {
		String query = "select * from faculty";

		preparedStatement = connection.prepareStatement(query);
		resultSet = preparedStatement.executeQuery();
		return resultSet;

	}

	// method to get specialization details according to given faculty and year
	public static ResultSet fillSpecialication(String faculty, int year) throws SQLException {
		String query = " select * from specialization where faculty = ? and year= ?";

		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, faculty);
		preparedStatement.setInt(2, year);
		resultSet = preparedStatement.executeQuery();
		return resultSet;

	}

	// method to get course fee according to given faculty a, year, and
	// specialization
	public static ResultSet fillSCourseFee(String faculty, int year, String specialization) throws SQLException {
		String query = " select * from specialization where faculty = ? and year= ? and specialization=?";

		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, faculty);
		preparedStatement.setInt(2, year);
		preparedStatement.setString(3, specialization);
		resultSet = preparedStatement.executeQuery();
		return resultSet;

	}

	// Method to get examination according to given parameters
	public static ResultSet getExaminationDetails(String faculty, int year_of_university, String specialization,
			int semester, int year) throws SQLException {

		String query = "select * from exams where faculty=? and year_of_university =? and specialization=? and semester=? and YEAR(date_of_exam) =?  ";

		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, faculty);
		preparedStatement.setInt(2, year_of_university);
		preparedStatement.setString(3, specialization);
		preparedStatement.setInt(4, semester);
		preparedStatement.setInt(5, year);

		resultSet = preparedStatement.executeQuery();
		return resultSet;

	}

	// Method to get examination according to year and faculty
	public static ResultSet getExaminationDetails(int year, String faculty) throws SQLException {

		String query = "select * from exams where faculty=? and YEAR(date_of_exam) =?";

		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, faculty);
		preparedStatement.setInt(2, year);
		resultSet = preparedStatement.executeQuery();
		return resultSet;

	}

}
