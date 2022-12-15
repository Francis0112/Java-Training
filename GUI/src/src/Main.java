package src;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
		//My_frame m = new My_frame();
		new Coke_float_layout();
		//sql_training();
		//The_Timer the_Timer = new The_Timer();
		//the_Timer.Oz();
		//The_Thread the_Thread1 = new The_Thread();
		//The_Thread2 the_Thread2 = new The_Thread2();
		//the_Thread1.start();
		//the_Thread1.join();
		//the_Thread2.start();
	}
	
	public static void sleeper() {
		for (int i = 5; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Woke up... woaah");
	}	
	
	public static void sql_training() throws SQLException {
		Test_sql ts = new Test_sql();
		Scanner scan = new Scanner(System.in);
		int _id;
		String username,email;
		System.out.println("Choose a command:\nPress 1-5\n1: Insert Data\n2: Update Data\n3: Delete Data\n4: View Data\n5: Exit");
		
		while (true) {
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1: {
				System.out.println("you have press 1: Insert Data");
				System.out.println("Register username:");
				username = scan.nextLine();
				System.out.println("Register email:");
				email = scan.nextLine();
				ts.pst = ts.con.prepareStatement("insert into users (username,email) values (?,?)");
				ts.pst.setString(1, username);
				ts.pst.setString(2, email);
				int x = ts.pst.executeUpdate();
				if(x==1) {
					System.out.println("Data Inserted!");
				}
				else {
					System.out.println("Data Insert Failed!");
				}
				break;
			}
			case 2:{
				System.out.println("you have press 2: Update Data");
				System.out.println("Enter user id:");
				_id = Integer.parseInt(scan.nextLine());
				System.out.println("new username:");
				username = scan.nextLine();
				System.out.println("new email:");
				email = scan.nextLine();
				ts.pst=ts.con.prepareStatement("update users set username=?, email=? where id=?");
				ts.pst.setString(1, username);
				ts.pst.setString(2, email);
				ts.pst.setInt(3, _id);
				ts.pst.executeUpdate();
				System.out.println("Data updated!");
				break;
			}
			case 3:{
				System.out.println("you have press 3: Delete Data");
				System.out.println("Enter user id to delete:");
				_id = Integer.parseInt(scan.nextLine());
				ts.pst=ts.con.prepareStatement("delete from users where id = ?");
				ts.pst.setInt(1, _id);
				ts.pst.executeUpdate();
				System.out.println("Data have been Deleted!");
				break;
			}
			case 4:{
				System.out.println("you have press 4: View Data");
				ts.stmt = ts.con.createStatement();
				ts.rs=ts.stmt.executeQuery("Select id,username,email from users");
				while(ts.rs.next()) {
					_id=ts.rs.getInt("id");
					username=ts.rs.getString("username");
					email=ts.rs.getString("email");
					System.out.print(_id+" ");
					System.out.print(username+" ");
					System.out.println(email+" ");
				}
				break;
			}
			case 5:{
				System.out.println("Thank you for your effort today. <3");
				System.exit(0);
				break;
			}
			default:
				System.out.println("invalid command!");
				break;
			}
		}
	}
}
