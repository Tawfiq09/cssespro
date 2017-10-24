package com.csse.payment.semester_payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public static void addSemesterPayment(SemesterPayment semesterPayment) {
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

		java.sql.Date sqlregisteredDate = new java.sql.Date(registeredDate.getTime());
		java.sql.Date sqldate = new java.sql.Date(date.getTime());

		String query = "insert into semesterpayment(student_id,student_name,student_email,curruent_year,year,semester,faculty,specialication,course_fee,registration_date,bank,branch,deposit_date) values('"
				+ studentId + "','" + studentName + "','" + studentEmail + "','" + currentYear + "','" + year + "','"
				+ semester + "','" + faculty + "','" + specialication + "','" + courseFee + "','" + sqlregisteredDate
				+ "','" + bankName + "','" + branchName + "','" + sqldate + "')";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
