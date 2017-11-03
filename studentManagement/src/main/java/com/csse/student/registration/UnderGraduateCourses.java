package com.csse.student.registration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnderGraduateCourses implements CourseAllocate{

	@Override
	public List<String> allocateCourse() {
		ArrayList<String> list=new ArrayList<String>();
		list.add("U-SE");
		list.add("U-Buss");  
		return list;
	}

}
