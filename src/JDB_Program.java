
import java.sql.*;
public class JDB_Program {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/myJDBC";
		String username="root";
		String password="12345";
		String query="create table Bank(Acc_No int primary key,Name varchar(30),Amount int)";
		try {
			//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver load is successful");
		//established the connection
		Connection con=DriverManager.getConnection(url,username,password);
		System.out.println("connection is established");
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
