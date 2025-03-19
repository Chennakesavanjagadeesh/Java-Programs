package com.learn.TemparorayRam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			System.out.println("Enter the value");
			student st=new student();
			Scanner scan=new Scanner(System.in);
			System.out.println("enter a acc_no");
			int Rollno=scan.nextInt();
			System.out.println("enter a Name");
			String Name=scan.next();
			System.out.println("enter a Amount");
			int age=scan.nextInt();
			st.setRollno(Rollno);
			st.setName(Name);
			st.setAge(age);
			smt.setInt(1,st.getRollno());
			smt.setString(2, st.getName());
			smt.setInt(3, st.getAge());
			smt.execute();
			System.out.println("query is executed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
