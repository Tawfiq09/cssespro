package com.csse.student.registration;

public enum StudentType {
	UNDERGRADUATE("UnderGraduate"),POSTGRADUATE("PostGraduate");
	
	 private String type;

	 StudentType(String type) {
	        this.type = type;
	    }

	    public String type() {
	        return type;
	    }
	
}
