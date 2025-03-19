package com.learn.AutoCommitRollBack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		Connection con=null;
		String query="update bank set Amount=Amount-? where Acc_No=1111";
		String query1="update bank set Amount=Amount+? where Acc_No=3333";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded the Driver Successfully"); 
			  con=DriverManager.getConnection(url,username,password);
			System.out.println("established the connection successfully");
			con.setAutoCommit(false);
			PreparedStatement smt=con.prepareStatement(query);
			PreparedStatement smt1=con.prepareStatement(query1);
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter a amount to be transfered");
			int amount=scan.nextInt();
			smt.setInt(1,amount);
			smt1.setInt(1,amount);
			smt.executeUpdate();
			System.out.println("the amount is successfully transferred Acc_No:1111");
			smt1.executeUpdate();
			System.out.println("the amount is debited successfully Acc_No:3333");
			con.commit();
			

	}catch(Exception e)
		{
		try {
			con.rollback();
			System.out.println("changes are Rollback");
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}

	}

}
}
