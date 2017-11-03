package com.csse.student.registration;

public enum DAOType {
	
	STUDENTDAO("StudentDAO");
	
	 private String dao;

	 DAOType(String dao) {
	        this.dao = dao;
	    }

	    public String dao() {
	        return dao;
	    }

}
