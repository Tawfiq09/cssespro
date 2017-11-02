package com.csse.studentManagement.paymentTestcases;

import org.testng.annotations.Test;

import com.csse.payment.exam_payment.ExamPaymentHandler;

import org.testng.annotations.BeforeTest;

public class ExamPaymentTestCase {
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  ExamPaymentHandler.setconnection();
  }

}
