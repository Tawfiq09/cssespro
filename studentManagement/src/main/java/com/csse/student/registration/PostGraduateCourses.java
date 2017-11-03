package com.csse.student.registration;

import java.util.ArrayList;
import java.util.List;

public class PostGraduateCourses implements CourseAllocate{

	@Override
	public List<String> allocateCourse() {
		ArrayList<String> list=new ArrayList<String>();
		list.add("P-SE");
		list.add("P-Buss");  
		return list;
	}

}
