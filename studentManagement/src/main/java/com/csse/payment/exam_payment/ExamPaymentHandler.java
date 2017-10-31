package com.csse.payment.exam_payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.csse.payment.DBConnection;

public class ExamPaymentHandler {

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

	public static boolean add(ExamPayment examPayment) {

		String student_id = examPayment.getStudent_id();
		String student_name = examPayment.getStudent_name();
		String student_email = examPayment.getStudent_email();
		int year = examPayment.getYear();
		String faculty = examPayment.getFaculty();
		int current_year = examPayment.getCurrent_year();
		String specialization = examPayment.getSpecialization();
		int semester = examPayment.getSemester();
		String Examination = examPayment.getExamination();
		Date registered_date = examPayment.getRegistered_date();
		double exam_fee = examPayment.getExam_fee();
		String bank = examPayment.getBank();
		String branch = examPayment.getBranch();
		Date deposit_date = examPayment.getDeposit_date();
		String status = examPayment.getStatus();

		java.sql.Date sqlregisteredDate = new java.sql.Date(registered_date.getTime());
		java.sql.Date sqldepositDate = new java.sql.Date(deposit_date.getTime());

		String query = "insert into exampayment values('" + student_id + "','" + student_name + "','" + student_email
				+ "','" + year + "','" + faculty + "','" + current_year + "','" + specialization + "','" + semester
				+ "','" + Examination + "','" + sqlregisteredDate + "','" + exam_fee + "','" + bank + "','" + branch
				+ "','" + sqldepositDate + "','" + status + "')";
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
	
	public static ResultSet studentSearch(String student_id) {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String query = "select student_id as 'Student Id',student_name as 'Student Name',faculty as 'Faculty',"
				+ "examination as 'Examination',registered_date as 'Registered Date',exam_fee as 'Exam Fee',"
				+ "bank as 'Bank',status as 'Status' from exampayment where student_id=? and Year(registered_date)=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student_id);
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
