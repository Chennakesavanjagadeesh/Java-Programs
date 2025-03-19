package com.learn.updateTable;

import java.sql.*;

public class Program {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="update student set Name='Kumaresh1' where Rollno=2";
				
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("load driver is successfully");
		Connection con=java.sql.DriverManager.getConnection(url,username,password);
		System.out.println("established the connection");
		Statement smt=con.createStatement();
		smt.execute(query);
		System.out.println("query executed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
