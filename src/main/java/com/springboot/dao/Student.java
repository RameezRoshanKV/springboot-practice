package com.springboot.dao;

import io.swagger.v3.oas.annotations.media.Schema;

public class Student {

	@Schema(name="userId",example = "1",required = true)
	private String id;
	@Schema(name="userName",example = "DemoName",required = true)
	private String name;
	@Schema(name="userAge",example = "30",required = true)
	private String age;
	@Schema(name="userEmail",example = "demo@gmail.com",required = true)
	private String email;
	@Schema(name="userDob",example = "23-09-1990",required = false)
	private String dob;
	@Schema(name="year",example = "3",required = false)
	private String year;
	@Schema(name="cgpa",example = "7.9",required = false)
	private String cgpa;
	
	public Student(String id, String name, String age, String email, String dob,String year) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.dob = dob;
		this.year=year;
	}
	
	public String getYear() {
		return year;
	}

	
	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
}
