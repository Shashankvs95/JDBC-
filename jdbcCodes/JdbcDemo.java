package com.jdbc.jdbcCodes;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JdbcDemo 
{
	public static void insert() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\shash\\Desktop\\J2EE\\jdbc\\dbDetails.properties");
		Properties p = new Properties();
		p.load(fr);
		String url = p.getProperty("url");
		String un = p.getProperty("user");
		String pw = p.getProperty("pw");

		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println("Enter the employee id: ");
		int eid = sc.nextInt();
		System.out.println("Enter the employee name: ");
		String name = sc.next();
		System.out.println("Enter the employee salary: ");
		int sal = sc.nextInt();
		System.out.println("Enter the employee date of joining: ");
		String date = sc.next();

		Employee employee = new Employee(eid, name, sal, date);

		String qry = "insert into employee.employees values(?,?,?,?);";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pw);
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, employee.getEid());
			pstmt.setString(2, employee.getName());
			pstmt.setInt(3, employee.getSal());
			pstmt.setString(4, employee.getDoj());
			pstmt.execute();
			System.out.println("Successfully inserted..");

		}catch(Exception e) {
			e.printStackTrace();
		}


	}

	public static void delete() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\shash\\Desktop\\J2EE\\jdbc\\dbDetails.properties");
		Properties p = new Properties();
		p.load(fr);
		String url = p.getProperty("url");
		String un = p.getProperty("user");
		String pw = p.getProperty("pw");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the eid to delete: ");
		int eid = sc.nextInt();

		Employee employee = new Employee();

		employee.setEid(eid);

		Connection con = null;
		PreparedStatement pstmt = null;

		String qry = "delete from employee.employees where eid=?;";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pw);

			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, employee.getEid());
			pstmt.executeUpdate();
			System.err.println("Deleted successfully..");

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void updateSal() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\shash\\Desktop\\J2EE\\jdbc\\dbDetails.properties");
		Properties p = new Properties();
		p.load(fr);
		String url = p.getProperty("url");
		String un = p.getProperty("user");
		String pw = p.getProperty("pw");

		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();

		Connection con = null;
		PreparedStatement pstmt = null;

		display();

		String qry = "update employee.employees set sal=? where eid=?;";

		System.out.println("Enter the eid to select the record");
		int eid = sc.nextInt();
		System.out.println("Enter the new salary update");
		int sal = sc.nextInt();

		employee.setEid(eid);
		employee.setSal(sal);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pw);
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, employee.getSal());
			pstmt.setInt(2, employee.getEid());
			pstmt.executeUpdate();
			System.out.println("Record updated successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void display() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\shash\\Desktop\\J2EE\\jdbc\\dbDetails.properties");
		Properties p = new Properties();
		p.load(fr);
		String url = p.getProperty("url");
		String un = p.getProperty("user");
		String pw = p.getProperty("pw");

		Scanner sc = new Scanner(System.in);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employee employee = new Employee();

		String qry = "select * from employee.employees";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pw);
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();
			System.out.println("Data fetched");
			System.out.println("EID\t" + "ENAME\t" + "SALARY\t" + "DATE_OF_JOIN\t");

			while(rs.next()) {
				employee.setEid(rs.getInt("eid"));
				employee.setName(rs.getString("name"));
				employee.setSal(rs.getInt("sal"));
				employee.setDoj(rs.getString("doj"));

				System.out.println(employee.getEid()+"\t"+employee.getName()+"\t"+employee.getSal()+"\t"+employee.getDoj());
			}
		}catch(Exception e){
			e.printStackTrace();
		}




	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		boolean b = true;

		while(b) {
			System.out.println("Enter the choice:");
			System.out.println(" 1. Insert\n 2. Delete\n 3. Update salary\n 4. Display\n 5. Exit");
			int ch = sc.nextInt();
			switch(ch) {
			case 1 : insert();
			break;
			case 2 : delete();
			break;
			case 3 : updateSal();
			break;
			case 4 : display();
			break;
			case 5 : b = false;
			break;
			default : System.out.println("Try again..");
			}
		}
		if(b == false) {
			System.out.println("Exit successful");
		}
	}
}
