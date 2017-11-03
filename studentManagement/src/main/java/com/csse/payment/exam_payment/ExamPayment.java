package com.csse.payment.exam_payment;

import java.util.Date;

public class ExamPayment {

	//structure of exam payment
	private String student_id;
	private String student_name;
	private String student_email;
	private int year;
	private String faculty;
	private int current_year;
	private String specialization;
	private int semester;
	private String Examination;
	private Date registered_date;
	private double exam_fee;
	private String bank;
	private String branch;
	private Date deposit_date;
	private String status;

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getCurrent_year() {
		return current_year;
	}

	public void setCurrent_year(int current_year) {
		this.current_year = current_year;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getExamination() {
		return Examination;
	}

	public void setExamination(String examination) {
		Examination = examination;
	}

	public Date getRegistered_date() {
		return registered_date;
	}

	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}

	public double getExam_fee() {
		return exam_fee;
	}

	public void setExam_fee(double exam_fee) {
		this.exam_fee = exam_fee;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getDeposit_date() {
		return deposit_date;
	}

	public void setDeposit_date(Date deposit_date) {
		this.deposit_date = deposit_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
