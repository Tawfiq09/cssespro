package com.csse.student.registration;

public class UnderGraduateStudent extends Student{

	public UnderGraduateStudent(String sid,String fullName, String nameWithInit, String nic, String stuCategry, String faculty,
			String degreeProg, long mobileNo, long age, String address, String personToCntact, String relationship,
			long gurdianMobile) {
		
		super(sid,fullName, nameWithInit, nic, stuCategry, faculty, degreeProg, mobileNo, age, address, personToCntact,
				relationship, gurdianMobile);
	}

	public UnderGraduateStudent(String fullName, String nameWithInit, String nic, String stuCategry, String faculty,
			String degreeProg, long mobileNo, long age, String address, String personToCntact, String relationship,
			long gurdianMobile) {
		
		super(fullName, nameWithInit, nic, stuCategry, faculty, degreeProg, mobileNo, age, address, personToCntact,
				relationship, gurdianMobile);
	}
	public UnderGraduateStudent() {
		allocatedCourses = new UnderGraduateCourses();
	}
	

}
