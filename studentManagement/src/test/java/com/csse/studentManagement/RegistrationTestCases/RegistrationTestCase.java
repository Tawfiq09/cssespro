package com.csse.studentManagement.RegistrationTestCases;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.csse.admin.HttpMessaheHandler;
import com.csse.db.utill.DAOManager;
import com.csse.student.registration.FacultyType;
import com.csse.student.registration.Student;
import com.csse.student.registration.StudentType;
import com.csse.student.registration.UnderGraduateStudent;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationTestCase {
 
	private String sid = "UnBu947634323";
	private String fullName = "dimuthu";
	private String nameWithInit = "K.D.Y.Viduranga";
	private String nic = "947634323v";
	private String stuCategry = StudentType.UNDERGRADUATE.type();
	private String faculty = FacultyType.IT.fType();
	private String degreeProg = "U-SE";
	private long mobileNo = 0771212323;
	private long age = 24;
	private String address = "kelaiya";
	private String personToCntact = "mallika";
	private String relationship = "mother";
	private long gurdianMobile = 0765654343;
	String jsonInString = null;
	
	@BeforeTest
	public void setValues() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		DAOManager dmger =new DAOManager();
		Student ustu = new UnderGraduateStudent(sid,fullName,nameWithInit,nic,stuCategry,faculty,degreeProg,
				mobileNo,age,address,personToCntact,relationship,gurdianMobile);
		jsonInString = mapper.writeValueAsString(ustu);
	}
	
	@Test
	public void saveStudent() throws Exception {
		HttpMessaheHandler.httpService("POST",jsonInString,"http://localhost:8081/admin.student/student/save");
	}
}
