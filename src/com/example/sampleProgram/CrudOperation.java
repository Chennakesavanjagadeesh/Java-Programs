package com.example.sampleProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrudOperation {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/WeJDBC";
		String username="root";
		String password="12345";
		String query1="create table Customer2(Cust_id int primary key,Name varchar(30),Age int)";
		String query2="insert into Customer2 values(1,'jaga',22),(2,'kumaresh',23)";
		String query3="select * from Customer2";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load the Driver Successfully");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Establish the connection successfully");
			Statement smt=con.createStatement();
			smt.execute(query1);
			smt.execute(query2);
			ResultSet rs=smt.executeQuery(query3);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+""+rs.getString(2)+" "+rs.getInt(3));
			}
			System.out.println("execute Successfully");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
