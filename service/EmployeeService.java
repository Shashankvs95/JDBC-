package com.home.service;

import com.home.bean.EmployeeData;

public interface EmployeeService 
{
	public EmployeeData getSingleRecord(int id);
	public void getAllRecords();
	public void insertRecord(EmployeeData a);
}
