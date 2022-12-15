package src;

import java.sql.*;

import javax.swing.JOptionPane;

public class Admin_connect {
	
	public Connection con;
	public PreparedStatement pst;
	public ResultSet rs;
	public Statement stm;

	public Admin_connect() {
		// TODO Auto-generated constructor stub
		Connect();
	}

	private void Connect() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hello_world","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something went wrong. Error!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database lost Connection. Error!");
		}
		
	}
}
