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

	// verify record already exist or not
	public static boolean checkRecordAlreadyExist(ExamPayment examPayment) {
		int count = 0;
		String student_id = examPayment.getStudent_id();
		int year = examPayment.getYear();
		int semester = examPayment.getSemester();
		String Examination = examPayment.getExamination();
		// Date registered_date = examPayment.getRegistered_date();
		// java.sql.Date sqlregisteredDate = new
		// java.sql.Date(registered_date.getTime());
		String query = "select * from exampayment where student_id=? and year=? and semester=? and examination=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student_id);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			preparedStatement.setString(4, Examination);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count++;
			}
			if (count > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// add exam payment
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

	// search student perspective
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

	// admin perspective student wise search
	public static ResultSet searchStudent(String student_id, int year) {
		String query = "select student_id as 'Student ID', student_name as 'Student Name', student_email as 'Student Email', "
				+ "year as 'Year', faculty as 'Faculty', year_of_university as 'year of university' , specialization as 'Specialization', "
				+ "semester as 'Semester', examination as 'Examination', registered_date as 'Registered Date', exam_fee as 'Exam Fee',"
				+ " bank as 'bank', branch as 'Branch', deposite_date as 'Deposit_date', status as 'Status' "
				+ "from exampayment where student_id=? and Year(registered_date)=?";
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

	// admin perspective exam wise search
	public static ResultSet search(String exam, int year) {

		String query = "select student_id as 'Student ID', student_name as 'Student Name', student_email as 'Student Email',"
				+ " year as 'Year', faculty as 'Faculty', year_of_university as 'year of university' , specialization as 'Specialization',"
				+ " semester as 'Semester', examination as 'Examination', registered_date as 'Registered Date', exam_fee as 'Exam Fee',"
				+ " bank as 'bank', branch as 'Branch', deposite_date as 'Deposit_date', status as 'Status' "
				+ "from exampayment where examination=? and Year(registered_date)=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, exam);
			preparedStatement.setInt(2, year);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// update exam payment
	public static boolean upadte(String sid, java.sql.Date regDate, String examination, String status) {

		String query = "update exampayment set status = '" + status
				+ "' where student_id=? and registered_date=? and examination=?  ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sid);
			preparedStatement.setDate(2, (java.sql.Date) regDate);
			preparedStatement.setString(3, examination);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;
	}

	//method for delete exam payment recode
	public static boolean delete(String sid, int year, int semester, String examination) {
		String query = "delete from exampayment where student_id=? and year=? and semester=? and examination=? ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sid);
			preparedStatement.setInt(2, year);
			preparedStatement.setInt(3, semester);
			preparedStatement.setString(4, examination);
			preparedStatement.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
