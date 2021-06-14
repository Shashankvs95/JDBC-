package com.home.dao;

import com.home.bean.EmployeeData;

public interface EmployeeDAO 
{
	public EmployeeData getSingleRecord(int id);
	public void getAllRecords();
	public void insertRecord(EmployeeData a);
}
