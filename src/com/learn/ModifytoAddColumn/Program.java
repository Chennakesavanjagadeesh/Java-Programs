package com.learn.ModifytoAddColumn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		System.out.println("enter your password");
		String password=scan.nextLine();
		System.out.println("enter your query");
		String query=scan.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded the Driver Successfully");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("established the connection successfully");
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(query);
			while(rs.next())
			{
			System.out.println(rs.getInt(1));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void where(boolean next) {
		// TODO Auto-generated method stub
		
	}

}
