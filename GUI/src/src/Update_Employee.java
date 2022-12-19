package src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_Employee extends JFrame {
	
	private void clear() {
		ID_box.setText(null);
		first_name_box.setText(null);
		last_name_box.setText(null);
		email_box.setText(null);
		contact_box.setText(null);
		position_box.setText(null);
		salary_box.setText(null);
		first_name_box.grabFocus();
	}
	
	private void update_data() throws SQLException {
		String id = ID_box.getText().trim().replaceAll("\\s", "");
		String fname = first_name_box.getText().trim().replaceAll("\\s", "");
		String lname = last_name_box.getText().trim().replaceAll("\\s", "");
		String email = email_box.getText().trim().replaceAll("\\s", "");
		String contact = contact_box.getText().trim().replaceAll("\\s", "");
		String position = position_box.getText().trim().replaceAll("\\s", "");
		String salary = salary_box.getText().trim().replaceAll("\\s", "");
		Admin_connect ad = new Admin_connect();
		if (ID_box.getText().equals("") || first_name_box.getText().equals("") ||
				last_name_box.getText().equals("") || email_box.getText().equals("") ||
				position_box.getText().equals("") || salary_box.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Invalid! Please Input valid Data on the field.");
		}
		else {
			ad.pst = ad.con.prepareStatement("update employee set firstname=?,lastname=?,email=?,contact=?,position=?,salary=? where emp_id=?");
			ad.pst.setString(1, fname);
			ad.pst.setString(2, lname);
			ad.pst.setString(3, email);
			ad.pst.setString(4, contact);
			ad.pst.setString(5, position);
			ad.pst.setString(6, salary);
			ad.pst.setString(7, id);
			ad.pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Record Updated!");
			System.out.println("Record updated.");
			clear();
		}
	}
	
	public Update_Employee() {
		setResizable(false);
		setTitle("Update Data");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "UPDATE DATA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 11, 404, 273);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("First_name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 55, 84, 14);
		panel.add(lblNewLabel);
		
		first_name_box = new JTextField();
		first_name_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		first_name_box.setColumns(10);
		first_name_box.setBounds(104, 50, 282, 25);
		panel.add(first_name_box);
		
		JButton submit_btn = new JButton("Update");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					update_data();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		submit_btn.setBounds(10, 230, 236, 32);
		panel.add(submit_btn);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(10, 85, 84, 14);
		panel.add(lblLastName);
		
		last_name_box = new JTextField();
		last_name_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		last_name_box.setColumns(10);
		last_name_box.setBounds(104, 80, 282, 25);
		panel.add(last_name_box);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 115, 84, 14);
		panel.add(lblEmail);
		
		email_box = new JTextField();
		email_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email_box.setColumns(10);
		email_box.setBounds(104, 110, 282, 25);
		panel.add(email_box);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContact.setBounds(10, 145, 84, 14);
		panel.add(lblContact);
		
		contact_box = new JTextField();
		contact_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contact_box.setColumns(10);
		contact_box.setBounds(104, 140, 282, 25);
		panel.add(contact_box);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPosition.setBounds(10, 175, 84, 14);
		panel.add(lblPosition);
		
		position_box = new JTextField();
		position_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		position_box.setColumns(10);
		position_box.setBounds(104, 170, 282, 25);
		panel.add(position_box);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalary.setBounds(10, 200, 73, 25);
		panel.add(lblSalary);
		
		salary_box = new JTextField();
		salary_box.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						update_data();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		salary_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		salary_box.setColumns(10);
		salary_box.setBounds(104, 200, 282, 25);
		panel.add(salary_box);
		
		JButton clear_btn = new JButton("Clear");
		clear_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		clear_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clear_btn.setBounds(256, 230, 130, 32);
		panel.add(clear_btn);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(10, 24, 84, 14);
		panel.add(lblId);
		
		ID_box = new JTextField();
		ID_box.setEditable(false);
		ID_box.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ID_box.setColumns(10);
		ID_box.setBounds(104, 19, 282, 25);
		panel.add(ID_box);
		setSize(458,334);
		setVisible(true);
		
	}

	/**
	 * 
	 */
	public void setID(String id) {
		ID_box.setText(id);
	}

	public void setFname(String fname) {
		first_name_box.setText(fname);
	}
	public void setLname(String lname) {
		last_name_box.setText(lname);
	}
	public void setEmail(String email) {
		email_box.setText(email);
	}
	public void setContact(String contact) {
		contact_box.setText(contact);
	}
	public void setPosition(String position) {
		position_box.setText(position);
	}
	public void setSalary(String salary) {
		salary_box.setText(salary);
	}
	
	private static final long serialVersionUID = 1L;
	public  JLabel label_emp_id;
	private JTextField first_name_box;
	private JTextField last_name_box;
	private JTextField email_box;
	private JTextField contact_box;
	private JTextField position_box;
	private JTextField salary_box;
	private JTextField ID_box;
}
