//import java.sql package;
import java.sql.*;
public class JDBC_Program1 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="insert into student values(1,'Jagadeesh'),(2,'vamsi')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded the Diver successfully");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("connection is established successfully");
			Statement smt=con.createStatement();
			smt.execute(query);
			System.out.println("query is executed");
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
