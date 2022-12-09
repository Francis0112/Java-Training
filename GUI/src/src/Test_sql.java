package src;

import java.sql.*;

public class Test_sql {
	
	public Connection con;
	public PreparedStatement pst;
	public Statement stmt;
	public ResultSet rs;
	
	
	public Test_sql() {
		// TODO Auto-generated constructor stub
		Connect();
	}
	
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hello_world","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
