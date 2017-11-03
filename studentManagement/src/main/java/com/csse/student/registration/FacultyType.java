package com.csse.student.registration;

public enum FacultyType {
	
	IT("IT"),ENGINEERING("Engineering"),BUSSINESS("Bussiness");

	private String fType;
	
	FacultyType(String fType){
		this.fType = fType;
	}
	
	public String fType() {
		return fType;
	}
}
