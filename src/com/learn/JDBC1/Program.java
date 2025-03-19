package com.learn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="create table Sales1(SNo int,Product_name varchar(30),Price int)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loading the Driver Successfully");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Establish the connection successfully");
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
