package com.csse.studentManagement.RegistrationTestCases;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class RegistrationTestSuit {
	
	public static void main(String args[]) {
		RegistrationTestCase tcase = new RegistrationTestCase();
		try {
			tcase.setValues();
			tcase.saveStudent();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
