package com.te.jdbcDemo;

import java.sql.*;

public class InsertStatic 
{
	public static void main(String[] args) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String qry = "insert into employee_info.employee1(?,?,?,?);";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306?user=root&password=admin";
			con=DriverManager.getConnection(dburl);
			
			pstmt = con.prepareStatement(qry);
			
			
			//set the values for place holder before execution
			
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Akash");
			pstmt.setInt(3, 25000);
//			pstmt.setDate(4, "2020-06-12");
			

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
