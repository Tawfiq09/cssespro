package com.csse.course.add_course;

import java.sql.Date;

public class addCourse {


	//structure of exam payment
	private String course_code;
	private String course_name;
	private String no_of_credits;
	private String faculty;
	private String graduate;
	private String year;
	private String sub_stream;
	private String lecture_in_charge;
	private Date from_date;
	private Date to_date;
	
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getNo_of_credits() {
		return no_of_credits;
	}
	public void setNo_of_credits(String no_of_credits) {
		this.no_of_credits = no_of_credits ;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSub_stream() {
		return sub_stream;
	}
	public void setSub_stream(String sub_stream) {
		this.sub_stream = sub_stream;
	}
	public String getLecture_in_charge() {
		return lecture_in_charge;
	}
	public void setLecture_in_charge(String lecture_in_charge) {
		this.lecture_in_charge = lecture_in_charge;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date date) {
		this.from_date =   (Date) date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date date) {
		this.to_date =  (Date) date;
	}

}
