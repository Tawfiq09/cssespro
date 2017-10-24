package com.csse.student.registration;

public abstract class Student {

	private String name;
	private int phoneNumber;
	CourseAllocate courses;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setCourses(CourseAllocate courses) {
		this.courses = courses;
	}
	 public abstract void getAllocateCourses();

}
