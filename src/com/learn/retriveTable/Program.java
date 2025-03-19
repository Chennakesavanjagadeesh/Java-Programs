package com.learn.retriveTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
	
				String url="jdbc:mysql://localhost:3306/myJDBC";
				String username="root";
				String password="12345";
				String query="select * from student";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Loaded the Driver Successfully");
					Connection con=DriverManager.getConnection(url,username,password);
					System.out.println("established the connection successfully");
					Statement smt=con.createStatement();
					ResultSet rs=smt.executeQuery(query);
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+" "+rs.getString(2));
					}
	
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		

	}


