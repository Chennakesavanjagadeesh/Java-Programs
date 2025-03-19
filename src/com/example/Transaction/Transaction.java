package com.example.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Transaction {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query1="update Customer set amount=amount-? where age=18";
		String query2="update Customer set amount=amount+? where age=19";
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load the successfully");
			con=DriverManager.getConnection(url,username,password);
			System.out.println("establish the connection sucessfully");
			con.setAutoCommit(false);
			PreparedStatement smt1=con.prepareStatement(query1);
			PreparedStatement smt2=con.prepareStatement(query2);
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter a amount");
			int amount=scan.nextInt();
			smt1.setInt(1, amount);
			smt2.setInt(1, amount);
			smt1.executeUpdate();
			System.out.println("Transaction  sucessfully");
			smt2.executeUpdate();
			System.out.println("Debited successfully");
			con.commit();
		}
		catch(Exception e)
		{
			try {
				con.rollback();
				System.out.println("changes to rollback");
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		
	}

}
