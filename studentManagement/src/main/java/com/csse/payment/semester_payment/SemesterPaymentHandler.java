package com.csse.payment.semester_payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.csse.payment.DBConnection;

public class SemesterPaymentHandler {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	// set db connection
	public static void setconnection() {

		if (connection == null) {
			try {
				connection = DBConnection.getconnection();
				// System.out.println("connected");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// verify student
	public static boolean verifystudent(SemesterPayment semesterPayment) {
		return false;
	}

	// add payment
	public static boolean addSemesterPayment(SemesterPayment semesterPayment) {
		String studentId = semesterPayment.getStudentId();
		String studentName = semesterPayment.getStudentName();
		String studentEmail = semesterPayment.getStudentEmail();
		Integer currentYear = semesterPayment.getCurrentYear();
		Integer year = semesterPayment.getYear();
		Integer semester = semesterPayment.getSemester();
		String faculty = semesterPayment.getFaculty();
		String specialication = semesterPayment.getSpecialication();
		double courseFee = semesterPayment.getCourseFee();
		java.util.Date registeredDate = semesterPayment.getRegisteredDate();
		// bank details
		String bankName = semesterPayment.getBankName();
		String branchName = semesterPayment.getBranchName();
		java.util.Date date = semesterPayment.getDate();
		String status = semesterPayment.getStatus();

		java.sql.Date sqlregisteredDate = new java.sql.Date(registeredDate.getTime());
		java.sql.Date sqldate = new java.sql.Date(date.getTime());

		String query = "insert into semesterpayment(student_id,student_name,student_email,curruent_year,year,semester,faculty,specialication,course_fee,registration_date,bank,branch,deposit_date,status) values('"
				+ studentId + "','" + studentName + "','" + studentEmail + "','" + currentYear + "','" + year + "','"
				+ semester + "','" + faculty + "','" + specialication + "','" + courseFee + "','" + sqlregisteredDate
				+ "','" + bankName + "','" + branchName + "','" + sqldate + "','" + status + "')";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// search for student perspective
	public static ResultSet studentSearch(String id) {

		int year = Calendar.getInstance().get(Calendar.YEAR);
		String query = "select student_id,student_name,year,semester,faculty,specialication,course_fee,registration_date,bank,status from semesterpayment where student_id=? and year=? ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setInt(2, year);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// search student wise admin perspective
	public static ResultSet adminSearchStudentWise(String sid, int year, int semester) {

		String query = "select student_id as 'Student Id',student_name as 'Student Name',student_email as 'Student Email',curruent_year as 'Current Year',"
				+ "year as 'Year',semester as 'Semester',faculty as 'Faculty',specialication as 'Specialication',"
				+ "course_fee as 'Course Fee',registration_date as 'Registred Date',bank as 'Bank',branch as 'Branch',deposit_date as 'Deposit Date',status as 'Status'"
				+ " from semesterpayment where student_id=? and year=? and semester=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sid);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// search faculty wise admin perspective
	public static ResultSet adminSearchFacultytWise(String faculty, int year, int semester) {

		String query = "select student_id as 'Student Id',student_name as 'Student Name',student_email as 'Student Email',curruent_year as 'Current Year',"
				+ "year as 'Year',semester as 'Semester',faculty as 'Faculty',specialication as 'Specialication',"
				+ "course_fee as 'Course Fee',registration_date as 'Registred Date',bank as 'Bank',branch as 'Branch',deposit_date as 'Deposit Date',status as 'Status'"
				+ " from semesterpayment where faculty=? and year=? and semester=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, faculty);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static boolean upadte(String sid, int year, int semester, String status) {

		String query = "update semesterpayment set status = '" + status
				+ "' where student_id=? and year=? and semester=?  ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sid);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;
	}

}
