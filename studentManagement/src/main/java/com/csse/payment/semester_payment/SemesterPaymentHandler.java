package com.csse.payment.semester_payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.csse.payment.DBConnection;

public class SemesterPaymentHandler {

	// this class all db operations of semester payment
	private static Connection connection = null;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	// set db connection
	public static void setconnection() throws ClassNotFoundException {

		if (connection == null) {

			connection = DBConnection.getconnection();

		}
	}

	// verify record already exist or not
	public static boolean checkRecordAlreadyExist(SemesterPayment semesterPayment) {
		int count = 0;
		String studentId = semesterPayment.getStudentId();
		Integer year = semesterPayment.getYear();
		Integer semester = semesterPayment.getSemester();
		String query = "select * from semesterpayment where student_id=? and year=? and semester=? ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, studentId);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				count++;
			}

			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			return false;
		}

		return false;
	}

	// add payment
	public static boolean add(SemesterPayment semesterPayment) {
		String studentId = semesterPayment.getStudentId();
		String studentName = semesterPayment.getStudentName();
		String studentEmail = semesterPayment.getStudentEmail();
		Integer currentYear = semesterPayment.getCurrentYear();
		Integer year = semesterPayment.getYear();
		Integer semester = semesterPayment.getSemester();
		String faculty = semesterPayment.getFaculty();
		String specialization = semesterPayment.getSpecialication();
		double courseFee = semesterPayment.getCourseFee();
		java.util.Date registeredDate = semesterPayment.getRegisteredDate();
		// bank details
		String bankName = semesterPayment.getBankName();
		String branchName = semesterPayment.getBranchName();
		java.util.Date date = semesterPayment.getDate();
		String status = semesterPayment.getStatus();

		java.sql.Date sqlregisteredDate = new java.sql.Date(registeredDate.getTime());
		java.sql.Date sqldate = new java.sql.Date(date.getTime());

		String query = "insert into semesterpayment(student_id,student_name,student_email,curruent_year,year,semester,faculty,specialization,course_fee,registration_date,bank,branch,deposit_date,status) values('"
				+ studentId + "','" + studentName + "','" + studentEmail + "','" + currentYear + "','" + year + "','"
				+ semester + "','" + faculty + "','" + specialization + "','" + courseFee + "','" + sqlregisteredDate
				+ "','" + bankName + "','" + branchName + "','" + sqldate + "','" + status + "')";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	// search for student perspective
	public static ResultSet studentSearch(String id) throws SQLException {

		int year = Calendar.getInstance().get(Calendar.YEAR);
		String query = "select student_id as 'Student Id',student_name as 'Student Name',curruent_year as 'Current Year',semester as 'Semester',"
				+ "faculty as 'Faculty',specialization as 'Specialization',course_fee as 'Course Fee',registration_date as 'Registred Date',"
				+ "bank as 'Bank',status as 'Status'" + " from semesterpayment where student_id=? and year=? ";
		
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setInt(2, year);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		
	}

	// search student wise admin perspective
	public static ResultSet adminSearchStudentWise(String sid, int year, int semester) throws SQLException {

		String query = "select student_id as 'Student Id',student_name as 'Student Name',student_email as 'Student Email',curruent_year as 'Current Year',"
				+ "year as 'Year',semester as 'Semester',faculty as 'Faculty',specialization as 'Specialization',"
				+ "course_fee as 'Course Fee',registration_date as 'Registred Date',bank as 'Bank',branch as 'Branch',deposit_date as 'Deposit Date',status as 'Status'"
				+ " from semesterpayment where student_id=? and year=? and semester=?";
	
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sid);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		

		
	}

	// search faculty wise admin perspective
	public static ResultSet adminSearchFacultytWise(String faculty, int year, int semester, int current_year)
			throws SQLException {

		String query = "select student_id as 'Student Id',student_name as 'Student Name',student_email as 'Student Email',curruent_year as 'Current Year',"
				+ "year as 'Year',semester as 'Semester',faculty as 'Faculty',specialization as 'Specialization',"
				+ "course_fee as 'Course Fee',registration_date as 'Registred Date',bank as 'Bank',branch as 'Branch',deposit_date as 'Deposit Date',status as 'Status'"
				+ " from semesterpayment where faculty=? and year=? and semester=? and curruent_year=?";
		
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, faculty);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			preparedStatement.setInt(4, current_year);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		
	}

	// update semester payment status
	public static boolean update(String sid, int year, int semester, String status) {

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
			return false;

		}
		
	}

	// delete record from semester payment
	public static boolean delete(String sid, int year, int semester) {
		String query = "delete from semesterpayment where student_id=? and year=? and semester=? ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sid);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

}
