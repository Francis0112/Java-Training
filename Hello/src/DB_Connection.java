import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB_Connection {

	public Connection connection = null;
	public java.sql.Statement statement;
	public ResultSet resultSet;
	public PreparedStatement preparedStatement;
	
	
	public DB_Connection() {
		
		try {
			
			
			System.out.println("hello");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hyundai","root","");
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from users");
			
			String username;
			String password;
			String firstname;
			String lastname;
			
			while (resultSet.next()) {
				username = resultSet.getString("username");
				password = resultSet.getString("password");
				firstname = resultSet.getString("firstname");
				lastname = resultSet.getString("lastname");
				System.out.println("username: "+username+"\nPassword: "+password+"\nFirstname: "+firstname+"\nLastname: "+lastname);
			}
			connection.close();
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}