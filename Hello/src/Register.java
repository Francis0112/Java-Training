import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JComboBox;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userfield;
	private JTextField firstnameField;
	private JTextField lastnameField;
	private JPasswordField passwordField;
	private JPasswordField confirmField;
	
	public Register() {
		
			
		JFrame frmHyundai = new JFrame();
		frmHyundai.setTitle("Hyundai");
		frmHyundai.setVisible(true);
		frmHyundai.getContentPane().setLayout(null);
		frmHyundai.setPreferredSize(new Dimension(390,330));

		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(6, 17, 83, 20);
		frmHyundai.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(6, 48, 83, 20);
		frmHyundai.getContentPane().add(lblPassword);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setBounds(6, 120, 83, 20);
		frmHyundai.getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setBounds(6, 151, 83, 20);
		frmHyundai.getContentPane().add(lblLastname);
		
		userfield = new JTextField();
		userfield.setBounds(120, 16, 222, 20);
		frmHyundai.getContentPane().add(userfield);
		userfield.setColumns(10);
		
		firstnameField = new JTextField();
		firstnameField.setBounds(120, 119, 222, 20);
		frmHyundai.getContentPane().add(firstnameField);
		firstnameField.setColumns(10);
		
		String[] types = {"User","Admin"};
		JComboBox comboBox = new JComboBox(types);
		comboBox.setBounds(120, 182, 222, 22);
		frmHyundai.getContentPane().add(comboBox);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setBounds(6, 183, 83, 20);
		frmHyundai.getContentPane().add(lblUserType);
		
		lastnameField = new JTextField();
		lastnameField.setBounds(120, 151, 222, 20);
		frmHyundai.getContentPane().add(lastnameField);
		lastnameField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Submit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			private void Submit() throws SQLException {
				// TODO Auto-generated method stub
				 
				String user = userfield.getText().trim().replaceAll("\\s", "");
				String fn = firstnameField.getText().trim().replaceAll("\\s", "");
				String ln = lastnameField.getText().trim().replaceAll("\\s", "");
				String type = comboBox.getSelectedItem().toString();
				char[] cat = passwordField.getPassword();
				char[] dog = confirmField.getPassword();
				String s_pass = String.valueOf(dog);
				String c_pass = String.valueOf(cat);
				
				
				if (!s_pass.equals(c_pass)) {
					JOptionPane.showMessageDialog(null, "Password do not match. please try again.", "Hyundai", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Admin_connect ad = new Admin_connect();
					ad.pst = ad.con.prepareStatement("insert into users (username, password, firstname, lastname, type) values (?,?,?,?,?)");
					ad.pst.setString(1, user);
					ad.pst.setString(2, s_pass);
					ad.pst.setString(3, fn);
					ad.pst.setString(4, ln);
					ad.pst.setString(5, type);
					int x = ad.pst.executeUpdate();
					
					if (x==1) {
						JOptionPane.showMessageDialog(null, "Registration Complete!");
						Clear();
					}
					ad.con.close();
				}
			}
		});
		btnSubmit.setBounds(6, 215, 89, 33);
		frmHyundai.getContentPane().add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clear();
			}
		});
		btnClear.setBounds(120, 215, 89, 33);
		frmHyundai.getContentPane().add(btnClear);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 48, 222, 20);
		frmHyundai.getContentPane().add(passwordField);
		
		JLabel lblConfirm = new JLabel("Confirm:");
		lblConfirm.setBounds(6, 79, 83, 20);
		frmHyundai.getContentPane().add(lblConfirm);
		
		confirmField = new JPasswordField();
		confirmField.setBounds(120, 79, 222, 20);
		frmHyundai.getContentPane().add(confirmField);
		
		frmHyundai.pack();
	}
	private void Clear() {
		// TODO Auto-generated method stub
		userfield.setText(null);
		passwordField.setText(null);
		confirmField.setText(null);
		firstnameField.setText(null);
		lastnameField.setText(null);
		userfield.requestFocus();
	}
}
