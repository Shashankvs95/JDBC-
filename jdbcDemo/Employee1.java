package com.te.jdbcDemo;

import java.util.Date;

public class Employee1 
{
	int eid;
	String name;
	int sal;
	Date doj;
	
	
	
	public Employee1() {
		super();
	}
	public Employee1(int eid, String name, int sal, Date doj) {
		super();
		this.eid = eid;
		this.name = name;
		this.sal = sal;
		this.doj = doj;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	
}
