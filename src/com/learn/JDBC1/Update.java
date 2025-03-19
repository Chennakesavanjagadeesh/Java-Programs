package com.learn.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="insert into Sales1 values(1,'single',34)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load the driver successfully");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Establish the Connection Successfully");
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
