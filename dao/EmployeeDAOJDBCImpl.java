package com.home.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.home.bean.EmployeeData;

public class EmployeeDAOJDBCImpl implements EmployeeDAO
{

	@Override
	public EmployeeData getSingleRecord(int id) {
		EmployeeData empdata = new EmployeeData();
		
		try {
			String dburl = "jdbc:mysql://localhost:3306/employee";
			Connection con = DriverManager.getConnection(dburl,"root","admin");
			Statement stmt = con.createStatement();
			
			String query = "select * from employees where eid = "+id+";";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				empdata.setEmpid(rs.getInt("eid"));
				empdata.setName(rs.getString("name"));
				empdata.setSalary(rs.getInt("sal"));
				empdata.setDoj(rs.getDate("doj"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empdata;
	}

	@Override
	public void getAllRecords() {
		System.out.println("Getting all the records");
	}

	@Override
	public void insertRecord(EmployeeData a) {
		System.out.println("Inserting all the records");
	}
	
}
