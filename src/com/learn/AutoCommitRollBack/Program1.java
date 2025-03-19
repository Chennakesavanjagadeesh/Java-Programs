package com.learn.AutoCommitRollBack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		Connection con=null;
		String query1="update bank set Amount=Amount-? where Acc_No=1111";
		String query2="update bank set Amount=Amount+? where Acc_No=3333";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Loaded the Driver Successfully"); 
		  con=DriverManager.getConnection(url,username,password);
		System.out.println("established the connection successfully");
		PreparedStatement pmt1=con.prepareStatement(query1);
		PreparedStatement pmt2=con.prepareStatement(query2);
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a amount to be transfered");
		int a=scan.nextInt();
		pmt1.setInt(a, 1);
		pmt2.setInt(a, 1);
		pmt1.executeUpdate();
		System.out.println("the amount is successfully transfered in the Account:1111");
		pmt2.executeUpdate();
		System.out.println("the amount is successfully debited in the Account:3333");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
