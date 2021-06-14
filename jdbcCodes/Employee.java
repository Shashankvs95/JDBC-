package com.jdbc.jdbcCodes;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable 
{
	private int eid;
	private String name;
	private int sal;
	private String doj;
	
	public Employee(int eid, String name, int sal, String doj) {
		super();
		this.eid = eid;
		this.name = name;
		this.sal = sal;
		this.doj = doj;
	}

	public Employee() {
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

	public String getDoj() {
		return doj;
	}

	public void setDoj(String date) {
		this.doj = date;
	}
	
	
}
