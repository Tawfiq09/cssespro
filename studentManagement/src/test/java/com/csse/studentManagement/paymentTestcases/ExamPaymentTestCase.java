package com.csse.studentManagement.paymentTestcases;

import org.testng.annotations.Test;

import com.csse.payment.exam_payment.ExamPayment;
import com.csse.payment.exam_payment.ExamPaymentHandler;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.testng.annotations.BeforeTest;

public class ExamPaymentTestCase {

	// all are positive test case

	String student_id = "IT15124567";
	String student_name = "saman";
	String student_email = "saman@gmail.com";
	int year = 2017;
	String faculty = "IT";
	int current_year = 3;
	String specialization = "SE";
	int semester = 2;
	String examination = "3rd-year-SE-semester2-final";
	Date registered_date = new Date();
	double exam_fee = 2000;
	String bank = "NTB";
	String branch = "Colombo";
	Date deposit_date = new Date();
	String status = "pending";
	java.sql.Date sqlRegdate = new java.sql.Date(registered_date.getTime());
	ExamPayment examPayment = new ExamPayment();
	ResultSet resultSet;

	@BeforeTest
	public void beforeTest() {
		ExamPaymentHandler.setconnection();
		examPayment.setStudent_id(student_id);
		examPayment.setStudent_name(student_name);
		examPayment.setStudent_email(student_email);
		examPayment.setYear(year);
		examPayment.setFaculty(faculty);
		examPayment.setCurrent_year(current_year);
		examPayment.setSpecialization(specialization);
		examPayment.setSemester(semester);
		examPayment.setExamination(examination);
		examPayment.setExam_fee(exam_fee);
		examPayment.setRegistered_date(registered_date);
		examPayment.setBank(bank);
		examPayment.setBranch(branch);
		examPayment.setDeposit_date(deposit_date);
		examPayment.setStatus(status);
	}

	// test for adding exam payment to database
	@Test(groups = "payment.exam")
	public void addPayment() {
		assertTrue(ExamPaymentHandler.add(examPayment));
	}

	// test for student perspective search
	@Test(groups = "payment.exam", dependsOnMethods = { "addPayment" })
	public void studentSearch() {
		resultSet = ExamPaymentHandler.studentSearch(student_id);
		try {
			while (resultSet.next()) {
				assertEquals(resultSet.getString("Student Id"), student_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// test for admin perspective search student wise
	@Test(groups = "payment.exam", dependsOnMethods = { "addPayment" })
	public void adminStudentSearch() {
		resultSet = ExamPaymentHandler.searchStudent(student_id, current_year);
		try {
			while (resultSet.next()) {
				assertEquals(resultSet.getString("Student Id"), student_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// test for update exam payment
	@Test(groups = "payment.exam", dependsOnMethods = { "addPayment" })
	public void update() {
		assertTrue(ExamPaymentHandler.upadte(student_id, sqlRegdate, examination, "verified"));
	}

	// test for delete exam payment recode
	@Test(groups = "payment.exam", dependsOnMethods = { "addPayment" })
	public void delete() {
		assertTrue(ExamPaymentHandler.delete(student_id, current_year, semester, examination));
	}

}
