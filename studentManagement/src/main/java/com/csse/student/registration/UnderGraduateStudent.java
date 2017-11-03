package com.csse.student.registration;

public class UnderGraduateStudent extends Student{

	public UnderGraduateStudent(String fullName,int age,String address) {
		//super(fullName,age,address);
	}
	
	/*@Override
	public void getAllocateCourses() {
		courses.allocateCourse();
	}
*/
	public UnderGraduateStudent() {
		allocatedCourses = new UnderGraduateCourses();
	}
	

}
