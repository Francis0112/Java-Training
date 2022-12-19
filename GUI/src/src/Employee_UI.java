package src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employee_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField first_name_box;
	private static JTextField last_name_box;
	private static JTextField email_box;
	private static JTextField contact_box;
	private static JTextField position_box;
	private static JTextField salary_box;
	
	private static void add_data() throws SQLException {
		String fname = first_name_box.getText().trim().replaceAll("\\s", "");
		String lname = last_name_box.getText().trim().replaceAll("\\s", "");
		String email = email_box.getText().trim().replaceAll("\\s", "");
		String contact = contact_box.getText().trim().replaceAll("\\s", "");
		String position = position_box.getText().trim().replaceAll("\\s", "");
		String salary = salary_box.getText().trim().replaceAll("\\s", "");
		Admin_connect ad = new Admin_connect();
		ad.pst = ad.con.prepareStatement("select * from employee where firstname=? and lastname=?");
		ad.pst.setString(1, fname);
		ad.pst.setString(2, lname);
		ad.rs = ad.pst.executeQuery();
		if (first_name_box.getText().equals("") ||
				last_name_box.getText().equals("") || email_box.getText().equals("") ||
				position_box.getText().equals("") || salary_box.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Invalid! Please Input valid Data on the field.");
		}
		else if (ad.rs.next()) {
			JOptionPane.showMessageDialog(null, "Invalid! Record already exists.");
		}
		else {
			ad.pst = ad.con.prepareStatement("insert into employee (firstname,lastname,email,contact,position,salary) values (?,?,?,?,?,?)");
			ad.pst.setString(1, fname);
			ad.pst.setString(2, lname);
			ad.pst.setString(3, email);
			ad.pst.setString(4, contact);
			ad.pst.setString(5, position);
			ad.pst.setString(6, salary);
			int x = ad.pst.executeUpdate();
			if (x==1) {
				JOptionPane.showMessageDialog(null, "Employee Record Added!");
				clear();
			}
			else {
				JOptionPane.showMessageDialog(null, "Error have been occured!");
				}
		}
	}
	
	private static void clear() {
		first_name_box.setText("");
		last_name_box.setText("");
		email_box.setText("");
		contact_box.setText("");
		position_box.setText("");
		salary_box.setText("");
		first_name_box.grabFocus();
	}
	
	public Employee_UI() {
		setTitle("ADD Employee Data");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "ADD Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 25, 392, 246);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First_name:");
		lblNewLabel.setBounds(6, 21, 84, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		first_name_box = new JTextField();
		first_name_box.setBounds(100, 16, 282, 25);
		panel.add(first_name_box);
		first_name_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		first_name_box.setColumns(10);
		
		JButton submit_btn = new JButton("ADD");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					add_data();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit_btn.setBounds(6, 196, 236, 32);
		panel.add(submit_btn);
		submit_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(6, 51, 84, 14);
		panel.add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		last_name_box = new JTextField();
		last_name_box.setBounds(100, 46, 282, 25);
		panel.add(last_name_box);
		last_name_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		last_name_box.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(6, 81, 84, 14);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		email_box = new JTextField();
		email_box.setBounds(100, 76, 282, 25);
		panel.add(email_box);
		email_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email_box.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setBounds(6, 111, 84, 14);
		panel.add(lblContact);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		contact_box = new JTextField();
		contact_box.setBounds(100, 106, 282, 25);
		panel.add(contact_box);
		contact_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contact_box.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(6, 141, 84, 14);
		panel.add(lblPosition);
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		position_box = new JTextField();
		position_box.setBounds(100, 136, 282, 25);
		panel.add(position_box);
		position_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		position_box.setColumns(10);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(6, 166, 73, 25);
		panel.add(lblSalary);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		salary_box = new JTextField();
		salary_box.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						add_data();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		salary_box.setBounds(100, 166, 282, 25);
		panel.add(salary_box);
		salary_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		salary_box.setColumns(10);
		
		JButton clear_btn = new JButton("Clear");
		clear_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		clear_btn.setBounds(252, 196, 130, 32);
		panel.add(clear_btn);
		clear_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setSize(452,321);
		setVisible(true);
	}
}
