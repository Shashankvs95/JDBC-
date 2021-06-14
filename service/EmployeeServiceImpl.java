package com.home.service;

import com.home.bean.EmployeeData;
import com.home.dao.EmployeeDAO;
import com.home.dao.GetDaoImpl;

public class EmployeeServiceImpl implements EmployeeService
{
	GetDaoImpl daoImpl = new GetDaoImpl();
	EmployeeDAO dao = daoImpl.getDaoImpl();
	
	
	@Override
	public EmployeeData getSingleRecord(int id) {
		if(id<=0) {
			return null;
		}else {
			System.out.println("Employee Service layer");
			return dao.getSingleRecord(id);
		}
	}
	@Override
	public void getAllRecords() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertRecord(EmployeeData a) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
