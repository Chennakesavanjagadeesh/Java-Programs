package com.learn.UserInputEX1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="insert into Bank values(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded the Driver Successfully"); 
			 Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("established the connection successfully");
			Scanner scan=new Scanner(System.in);
			PreparedStatement smt=con.prepareStatement(query);
			System.out.println("Enter a rows");
			int num=scan.nextInt();
			for(int i=1;i<=num;i++)
			{
			
				System.out.println("enter a acc_no"+i);
				int Acc_No=scan.nextInt();
				System.out.println("enter a Name"+i);
				String Name=scan.next();
				System.out.println("enter a Amount"+i);
				int Amount=scan.nextInt();
				smt.setInt(1, Acc_No);
				smt.setString(2, Name);
				smt.setInt(3,Amount);
				smt.execute();
				System.out.println("row are affected in table");
			}

	}catch(Exception e)
		{
		e.printStackTrace();
		}

}
}
