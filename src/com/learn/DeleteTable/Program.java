package com.learn.DeleteTable;

import java.sql.*;

public class Program {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="delete from student where Rollno=2";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded the Driver Successfully");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("established the connection successfully");
			Statement smt=con.createStatement();
			smt.execute(query);
			System.out.println("query is executed");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
