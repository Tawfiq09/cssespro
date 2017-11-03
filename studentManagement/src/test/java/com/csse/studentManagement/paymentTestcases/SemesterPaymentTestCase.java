package com.csse.studentManagement.paymentTestcases;

import org.testng.annotations.Test;

import com.csse.payment.semester_payment.SemesterPayment;
import com.csse.payment.semester_payment.SemesterPaymentHandler;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.testng.annotations.BeforeTest;

public class SemesterPaymentTestCase {

	// all are positive test

	String studentId = "IT15124567";
	String studentName = "saman";
	String studentEmail = "saman@gmail.com";
	Integer currentYear = 3;
	Integer year = 2017;
	Integer semester = 2;
	String faculty = "IT";
	String specialization = "SE";
	double courseFee = 105000.00;
	java.util.Date registeredDate = new Date();
	String bankName = "BOC";
	String branchName = "Gampaha";
	java.util.Date date = new Date();
	String status = "pending";
	SemesterPayment semeterpayment = new SemesterPayment();
	ResultSet resultSet;

	@BeforeTest
	public void beforeTest() throws ClassNotFoundException {
		SemesterPaymentHandler.setconnection();

		semeterpayment.setStudentId(studentId);
		semeterpayment.setStudentName(studentName);
		semeterpayment.setStudentEmail(studentEmail);
		semeterpayment.setCurrentYear(currentYear);
		semeterpayment.setYear(year);
		semeterpayment.setSemester(semester);
		semeterpayment.setFaculty(faculty);
		semeterpayment.setSpecialication(specialization);
		semeterpayment.setCourseFee(courseFee);
		semeterpayment.setRegisteredDate(registeredDate);
		semeterpayment.setBankName(bankName);
		semeterpayment.setBranchName(branchName);
		semeterpayment.setDate(date);
		semeterpayment.setStatus(status);

	}

	// test for add semester payent
	@Test(groups = "payment.semester")
	public void addpayment() {
		try {
			assertTrue(SemesterPaymentHandler.add(semeterpayment));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// test for student perspective search
	@Test(groups = "payment.semester", dependsOnMethods = { "addpayment" })
	public void studentSearch() throws SQLException {
		resultSet = SemesterPaymentHandler.studentSearch(studentId);

		try {
			while (resultSet.next()) {
				assertEquals(resultSet.getString("Student Id"), studentId);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// test for admin perspective student wise search
	@Test(groups = "payment.semester", dependsOnMethods = { "addpayment" })
	public void adminSearchStudentWise() throws SQLException {
		resultSet = SemesterPaymentHandler.adminSearchStudentWise(studentId, year, semester);

		try {
			while (resultSet.next()) {
				assertEquals(resultSet.getString("Student Id"), studentId);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test(groups = "payment.semester", dependsOnMethods = { "addpayment" })
	// public void adminSearchFacultytWise() {
	// resultSet = SemesterPaymentHandler.adminSearchFacultytWise(faculty, year,
	// semester, currentYear);
	// try {
	// while (resultSet.next()) {
	// assertEquals(resultSet.getString("student_id"), studentId);
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	// test for update semester payment
	@Test(groups = "payment.semester", dependsOnMethods = { "addpayment" })
	public void update() {
		try {
			assertTrue(SemesterPaymentHandler.update(studentId, year, semester, "verified"));
		} catch (Exception e) {

		}
	}

	// test for delete semester payment
	@Test(groups = "payment.semester", dependsOnMethods = { "addpayment" })
	public void delete() {
		try {
			assertTrue(SemesterPaymentHandler.delete(studentId, year, semester));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
