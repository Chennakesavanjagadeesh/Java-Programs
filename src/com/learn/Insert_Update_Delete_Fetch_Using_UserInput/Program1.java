package com.learn.Insert_Update_Delete_Fetch_Using_UserInput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
			String url="jdbc:mysql://localhost:3306/myJDBC";
			String username="root";
			String password="12345";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Loaded the Driver Successfully"); 
				 Connection con=DriverManager.getConnection(url,username,password);
				System.out.println("established the connection successfully");
				System.out.println("enter your Option");
				int num=scan.nextInt();
				if(num!=0)
				{
					switch(num)
					{
					case 1:
						System.out.println("enter a Rollno");
						int Rollno=scan.nextInt();
						System.out.println("enter a Name");
						String Name=scan.next();
						System.out.println("enter a age");
						int age=scan.nextInt();
						Insert(con);
						break;
					
				case 2:
					Update(con);
					break;
				
			case 3:
				Delete(con);
				break;
			
		case 4:
			Fetch(con);
			break;
		
				}
				
		}
				else
				{
					System.out.println("");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			

		}

		 static void Insert(Connection con) {
			 String query="insert into student values(12,'vamsi',27)";
			 try {
				 Statement smt=con.createStatement();
			smt.execute(query);
			System.out.println("query is inserted");
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
		 }
			 static void Update(Connection con) {
				 try {
				String query="update student set Name='kuma' where Rollno=3";
				Statement smt=con.createStatement();
				smt.executeUpdate(query);
				System.out.println("query is Updated");
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
			 }
				 static void Delete(Connection con) {
					 try {
					String query="delete from student where Rollno=3";
					Statement smt=con.createStatement();
					smt.executeUpdate(query);
					System.out.println("query is deleted");
					 }
					 catch(Exception e)
					 {
						 e.printStackTrace();
					 }
				 }
				 static void Fetch(Connection con) {
					 try {
					String query="select *from student";
					Statement smt=con.createStatement();
					ResultSet rs=smt.executeQuery(query);
					while(rs.next())
					System.out.println(rs.getInt(1)+" " + rs.getString(2)+" "+rs.getInt(3));
					 }
					 catch(Exception e)
					 {
						 e.printStackTrace();
					 }
					
					
		}

	}


