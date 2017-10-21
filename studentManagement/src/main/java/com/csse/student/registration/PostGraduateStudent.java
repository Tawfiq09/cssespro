package com.csse.student.registration;

public class PostGraduateStudent extends Student{

	public PostGraduateStudent() {
		super();
	}
	
	@Override
	public void getAllocateCourses() {
		courses.allocateCourse();
	}

	

}
