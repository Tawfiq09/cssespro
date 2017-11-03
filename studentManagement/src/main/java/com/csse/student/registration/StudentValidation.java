package com.csse.student.registration;

public class StudentValidation {

	public static boolean validateNicNo(String nic) {
		boolean status = false;
		if(nic.length() != 10 || !nic.contains("v")) {
			status = true;
		}
		
		return status;
	}
	
	public static boolean validateMobileNo(Long mobileNum) {
		boolean status = false;
		System.out.println("asaqqs"+String.valueOf(mobileNum).length());
		if(String.valueOf(mobileNum).length() != 10) {
			status = true;
		}
		
		return status;
	}
	
	public static boolean validateAge(Long age) {
		boolean status = false;
		if((int) (long) age<18 || (int) (long) age>80) {
			status = true;
		}
		
		return status;
	} 
}
