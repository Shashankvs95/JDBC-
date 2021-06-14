package com.home.dao;

import java.util.Scanner;

public class GetDaoImpl // Factory or helper class 
{
	String type = "jdbc";
	
	public EmployeeDAO getDaoImpl() {
		if(type.equalsIgnoreCase("jdbc")) {
			return new EmployeeDAOJDBCImpl();
		}else if(type.equalsIgnoreCase("hibernate")) {
			return new EmployeeDAOHIBERNATEImpl();
		}else if(type.equalsIgnoreCase("spring")) {
			return new EmployeeDAOSPRINGImpl();
		}return null;
	}
}
