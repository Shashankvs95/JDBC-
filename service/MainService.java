package com.home.service;


import com.home.bean.EmployeeData;

public class MainService 
{
	public static void main(String[] args) {
		
		EmployeeServiceImpl esi = new EmployeeServiceImpl();
		
		EmployeeData emp = esi.getSingleRecord(1);
		
		System.out.println(emp.getEmpid());
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
		System.out.println(emp.getDoj());
	}
}
