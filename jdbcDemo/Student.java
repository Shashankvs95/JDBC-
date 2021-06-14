package com.te.jdbcDemo;

public class Student 
{
	int sid;
	String name;
	String email;
	long number;
	
	public Student() {
		super();
	}
	public Student(int sid, String name, String email, long number) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.number = number;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	
}
