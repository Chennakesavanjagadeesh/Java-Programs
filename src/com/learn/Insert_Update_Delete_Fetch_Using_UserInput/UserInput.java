package com.learn.Insert_Update_Delete_Fetch_Using_UserInput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="insert into sales1 values(?,?,?)";
		String query1= "select * from sales1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("load the Driver Successfully");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Establish the connection Successfully");
			PreparedStatement smt=con.prepareStatement(query);
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter a SNo");
			int sno=scan.nextInt();
			System.out.println("Enter a product name");
			String productName=scan.next();
			System.out.println("Enter a price");
			int price=scan.nextInt();
			smt.setInt(1,sno);
			smt.setString(2, productName);
			smt.setInt(3, price);
			smt.executeUpdate();
			PreparedStatement smt1 = con.prepareStatement(query1);
			ResultSet rs=smt1.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			System.out.println("query is executed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
