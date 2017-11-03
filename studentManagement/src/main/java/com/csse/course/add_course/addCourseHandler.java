package com.csse.course.add_course;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.csse.course.DBConnection;

public class addCourseHandler {


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
	public static boolean checkRecordAlreadyExist(addCourse addcourse) {
		int count = 0;
		String course_code = addcourse.getCourse_code();
		String query = "select * from courses where course_code=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course_code);
			
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

	// add course
	public static boolean add(addCourse addcourse) {
		
		 String course_code = addcourse.getCourse_code();
		 String course_name = addcourse.getCourse_name();
		 String no_of_credits = addcourse.getNo_of_credits();
		 String faculty = addcourse.getFaculty();
		 String graduate = addcourse.getGraduate();
		 String year = addcourse.getYear();
		 String sub_stream = addcourse.getSub_stream();
		 String lecture_in_charge = addcourse.getLecture_in_charge();
		 Date from_date = addcourse.getFrom_date();
		 Date to_date = addcourse.getTo_date();

		java.sql.Date sqlfromdate = new java.sql.Date(from_date.getTime());
		java.sql.Date sqltodate = new java.sql.Date(to_date.getTime());

		String query = "insert into courses values('" + course_code + "','" + course_name + "','" + no_of_credits
				+ "','" + faculty + "','" + graduate + "','" + year + "','" + sub_stream
				+ "','" + lecture_in_charge + "','" + sqlfromdate + "','" + sqltodate + "')";
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

	// search by course code 
	public static ResultSet courseSearch(String course_code) {

		
		String query = "select course_code as 'Course code',course_name as 'Course Name',no_of_credits as 'No of credits',"
				+ "faculty as 'Faculty',graduate as 'Graduate status',year as 'Year',"
				+ "sub_stream as 'Subject stream',lecture_in_charge as 'Lecture in charge', "
				+ "from_date as 'From date',to_date as 'To date' from courses where course_code=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course_code);
			
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	//load details
	
public static ResultSet courseload() {

		
		String query = "select course_code as 'Course code',course_name as 'Course Name',no_of_credits as 'No of credits',"
				+ "faculty as 'Faculty',graduate as 'Graduate status',year as 'Year',"
				+ "sub_stream as 'Subject stream',lecture_in_charge as 'Lecture in charge', "
				+ "from_date as 'From date',to_date as 'To date' from courses ";
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

	
	
	// update course
	public static boolean update(addCourse addcourse) {
		
		 String course_code = addcourse.getCourse_code();
		 String course_name = addcourse.getCourse_name();
		 String no_of_credits = addcourse.getNo_of_credits();
		 String faculty = addcourse.getFaculty();
		 String graduate = addcourse.getGraduate();
		 String year = addcourse.getYear();
		 String sub_stream = addcourse.getSub_stream();
		 String lecture_in_charge = addcourse.getLecture_in_charge();
		 Date from_date = addcourse.getFrom_date();
		 Date to_date = addcourse.getTo_date();

		java.sql.Date sqlfromdate = new java.sql.Date(from_date.getTime());
		java.sql.Date sqltodate = new java.sql.Date(to_date.getTime());

		String query = "update courses set course_name='" + course_name + "',no_of_credits='" + no_of_credits
				+ "',faculty='" + faculty + "',graduate='" + graduate + "',year='" + year + "',sub_stream='" + sub_stream
				+ "',lecture_in_charge='" + lecture_in_charge + "',from_date='" + sqlfromdate + "',to_date='" + sqltodate + "' where "
						+ "course_code =?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course_code);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	//method for delete exam payment recode
	public static boolean delete(String course_code) {
		String query = "delete from courses where course_code=? ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course_code);
			preparedStatement.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
}
