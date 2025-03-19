package com.learn.Insert_Update_Delete_Fetch_Using_UserInput;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="insert into student values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded the Driver Successfully"); 
			 Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("established the connection successfully");
			PreparedStatement smt=con.prepareStatement(query);
			Scanner scan=new Scanner(System.in);
			System.out.println("enter a Rollno");
			int Rollno=scan.nextInt();
			System.out.println("enter a Name");
			String Name=scan.next();
			System.out.println("enter a age");
			int age=scan.nextInt();
			smt.setInt(1, Rollno);
			smt.setString(2, Name);
			smt.setInt(3, age);
			smt.execute();
			System.out.println("row are inserted successfully");
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
}
