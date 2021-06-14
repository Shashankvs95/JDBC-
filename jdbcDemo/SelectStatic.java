package com.te.jdbcDemo;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class SelectStatic
{
	public static void main(String[] args) {



		Student s = new Student();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;


		try {

			FileInputStream fis = new FileInputStream("properties.properties");
			
			Properties p = new Properties();
			p.load(fis);
			con = DriverManager.getConnection(p.getProperty("dburl"),p.getProperty("user"),p.getProperty("pwny"));
			
			
			
			String dburl = "jdbc:mysql://localhost:3306/employee_info";
			con=DriverManager.getConnection(dburl,"root","admin");

			String qry = "select * from student where sid=1;";
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);

			while(rs.next()) {
				s.setSid(rs.getInt("sid"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setNumber(rs.getLong("number"));

			}


		}catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println(s.sid+" "+s.name+" "+s.email+" "+s.number);
	}
}
