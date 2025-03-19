package com.example.sampleProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program1 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/WeJDBC";;
		String username="root";
		String password="12345";
		String query="create table Student(RollNo int,Name varchar(30),PhoneNumber int)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("load the Driver successfully");
			//establish the connection
			Connection con=DriverManager.getConnection(url, username, password);
			System.out.println("estabish the connection Successfully");
			Statement smt=con.createStatement();
			smt.execute(query);
			System.out.println("execute query successfully");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
