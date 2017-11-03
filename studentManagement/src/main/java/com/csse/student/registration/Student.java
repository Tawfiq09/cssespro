package com.csse.student.registration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public abstract class Student implements Serializable{

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"sid",
	"fullName",
	"nameWithInit",
	"nic",
	"stuCategry",
	"faculty",
	"degreeProg",
	"mobileNo",
	"age",
	"address",
	"personToCntact",
	"relationship",
	"gurdianMobile"
	})
	

	@JsonProperty("sid")
	private String sid;
	@JsonProperty("fullName")
	private String fullName;
	@JsonProperty("nameWithInit")
	private String nameWithInit;
	@JsonProperty("nic")
	private String nic;
	@JsonProperty("stuCategry")
	private String stuCategry;
	@JsonProperty("faculty")
	private String faculty;
	@JsonProperty("degreeProg")
	private String degreeProg;
	@JsonProperty("mobileNo")
	private long mobileNo;
	@JsonProperty("age")
	private long age;
	@JsonProperty("address")
	private String address;
	@JsonProperty("personToCntact")
	private String personToCntact;
	@JsonProperty("relationship")
	private String relationship;
	@JsonProperty("gurdianMobile")
	private long gurdianMobile;
	CourseAllocate allocatedCourses;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	* No args constructor for use in serialization
	* 
	*/
	public Student() {
	}


	public Student(String sid,String fullName, String nameWithInit, String nic, String stuCategry, String faculty,
			String degreeProg, long mobileNo, long age, String address, String personToCntact, String relationship,
			long gurdianMobile) {
		this.sid = sid;
		this.fullName = fullName;
		this.nameWithInit = nameWithInit;
		this.nic = nic;
		this.stuCategry = stuCategry;
		this.faculty = faculty;
		this.degreeProg = degreeProg;
		this.mobileNo = mobileNo;
		this.age = age;
		this.address = address;
		this.personToCntact = personToCntact;
		this.relationship = relationship;
		this.gurdianMobile = gurdianMobile;
	}
	
	public Student(String fullName, String nameWithInit, String nic, String stuCategry, String faculty,
			String degreeProg, long mobileNo, long age, String address, String personToCntact, String relationship,
			long gurdianMobile) {
		this.fullName = fullName;
		this.nameWithInit = nameWithInit;
		this.nic = nic;
		this.stuCategry = stuCategry;
		this.faculty = faculty;
		this.degreeProg = degreeProg;
		this.mobileNo = mobileNo;
		this.age = age;
		this.address = address;
		this.personToCntact = personToCntact;
		this.relationship = relationship;
		this.gurdianMobile = gurdianMobile;
	}

	@JsonProperty("sid")
	public String getSid() {
		return sid;
	}

	@JsonProperty("sid")
	public void setSid(String sid) {
		this.sid = sid;
	}

	@JsonProperty("fullName")
	public String getFullName() {
	return fullName;
	}

	@JsonProperty("fullName")
	public void setFullName(String fullName) {
	this.fullName = fullName;
	}
	
	@JsonProperty("nameWithInit")
	public String getNameWithInit() {
		return nameWithInit;
	}

	@JsonProperty("nameWithInit")
	public void setNameWithInit(String nameWithInit) {
		this.nameWithInit = nameWithInit;
	}

	@JsonProperty("nic")
	public String getNic() {
		return nic;
	}

	@JsonProperty("nic")
	public void setNic(String nic) {
		this.nic = nic;
	}

	@JsonProperty("stuCategry")
	public String getStuCategry() {
		return stuCategry;
	}

	@JsonProperty("stuCategry")
	public void setStuCategry(String stuCategry) {
		this.stuCategry = stuCategry;
	}

	@JsonProperty("faculty")
	public String getFaculty() {
		return faculty;
	}

	@JsonProperty("faculty")
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@JsonProperty("degreeProg")
	public String getDegreeProg() {
		return degreeProg;
	}

	@JsonProperty("degreeProg")
	public void setDegreeProg(String degreeProg) {
		this.degreeProg = degreeProg;
	}

	@JsonProperty("mobileNo")
	public long getMobileNo() {
		return mobileNo;
	}

	@JsonProperty("mobileNo")
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@JsonProperty("age")
	public long getAge() {
	return age;
	}

	@JsonProperty("age")
	public void setAge(int age) {
		this.age = age;
	}

	@JsonProperty("address")
	public String getAddress() {
	return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
	this.address = address;
	}

	@JsonProperty("personToCntact")
	public String getPersonToCntact() {
		return personToCntact;
	}

	@JsonProperty("personToCntact")
	public void setPersonToCntact(String personToCntact) {
		this.personToCntact = personToCntact;
	}

	@JsonProperty("relationship")
	public String getRelationship() {
		return relationship;
	}

	@JsonProperty("relationship")
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@JsonProperty("gurdianMobile")
	public long getGurdianMobile() {
		return gurdianMobile;
	}

	@JsonProperty("gurdianMobile")
	public void setGurdianMobile(int gurdianMobile) {
		this.gurdianMobile = gurdianMobile;
	}
	
	public CourseAllocate getAllocatedCourses() {
		return allocatedCourses;
	}

	public void setAllocatedCourses(CourseAllocate allocatedCourses) {
		this.allocatedCourses = allocatedCourses;
	}
	
	public  List<String> performAllocateCourse() {
		return allocatedCourses.allocateCourse();
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
	
}
