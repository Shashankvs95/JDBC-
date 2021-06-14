package com.te.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JdbcDemo 
{
	public static void main(String[] args) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("jdbc:mysql://localhost:3306?user=root&password=admin").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		try {
			String dburl = "jdbc:mysql://localhost:3306?user=root&password=admin";
			con=DriverManager.getConnection(dburl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String qry = "select * from employee;";
		
	}
}
