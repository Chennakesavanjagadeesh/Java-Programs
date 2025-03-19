package com.example.sampleProgram;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

public class userInput {
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/WeJDBC";
		String username="root";
		String password="12345";
		String query="insert into Customer values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("load the Driver successfully");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("establish the connection successfully");
			PreparedStatement pmt1= con.prepareStatement(query);
			Scanner scan=new Scanner(System.in);
			System.out.println("enter the customer id");
			int id=scan.nextInt();
			System.out.println("enter the customer Name");
			String name=scan.next();
			System.out.println("enter the customer age");
			int age=scan.nextInt();
			pmt1.setInt(1,id);
			pmt1.setString(2,name);
			pmt1.setInt(3,age);
			pmt1.execute();
			System.out.println("execute successfully");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
