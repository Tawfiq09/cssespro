package com.csse.student.registration;

public class UnderGraduateStudent extends Student{

	public UnderGraduateStudent() {
		super();
	}
	
	@Override
	public void getAllocateCourses() {
		courses.allocateCourse();
	}

	

}
