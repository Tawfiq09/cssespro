package com.csse.student.registration;

import java.util.Map;

public class PostGraduateStudent extends Student{

	public PostGraduateStudent(String sid,String fullName, String nameWithInit, String nic, String stuCategry, String faculty,
			String degreeProg, long mobileNo, long age, String address, String personToCntact, String relationship,
			long gurdianMobile) {
		
		super(sid,fullName, nameWithInit, nic, stuCategry, faculty, degreeProg, mobileNo, age, address, personToCntact,
				relationship, gurdianMobile);
	}

	public PostGraduateStudent(String fullName, String nameWithInit, String nic, String stuCategry, String faculty,
			String degreeProg, long mobileNo, long age, String address, String personToCntact, String relationship,
			long gurdianMobile) {
		
		super(fullName, nameWithInit, nic, stuCategry, faculty, degreeProg, mobileNo, age, address, personToCntact,
				relationship, gurdianMobile);
	}
	
	public PostGraduateStudent(){
		allocatedCourses = new PostGraduateCourses();
	}

	

}
