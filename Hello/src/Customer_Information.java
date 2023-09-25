import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Customer_Information extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fnameField;
	private JTextField lnameField;
	private JTextField mnameField;
	private JTextField addressField;
	private JTextField emailField;
	private JTextField contactField;
	private JTextField tinField;
	public Customer_Information() {

		
		JFrame frmHyundai = new JFrame();
		frmHyundai.setTitle("Hyundai");
		frmHyundai.setVisible(true);
		frmHyundai.getContentPane().setLayout(null);
		frmHyundai.setPreferredSize(new Dimension(452,350));
		
		JLabel lblNewLabel = new JLabel("Firstname");
		lblNewLabel.setBounds(10, 53, 85, 14);
		frmHyundai.getContentPane().add(lblNewLabel);
		
		fnameField = new JTextField();
		fnameField.setBounds(102, 50, 322, 20);
		frmHyundai.getContentPane().add(fnameField);
		fnameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Information");
		lblNewLabel_1.setBounds(10, 28, 135, 14);
		frmHyundai.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setBounds(10, 81, 85, 14);
		frmHyundai.getContentPane().add(lblLastname);
		
		lnameField = new JTextField();
		lnameField.setColumns(10);
		lnameField.setBounds(102, 78, 322, 20);
		frmHyundai.getContentPane().add(lnameField);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(10, 109, 85, 14);
		frmHyundai.getContentPane().add(lblMiddleName);
		
		mnameField = new JTextField();
		mnameField.setColumns(10);
		mnameField.setBounds(102, 106, 322, 20);
		frmHyundai.getContentPane().add(mnameField);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 137, 85, 14);
		frmHyundai.getContentPane().add(lblAddress);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(102, 134, 322, 20);
		frmHyundai.getContentPane().add(addressField);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 165, 85, 14);
		frmHyundai.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(102, 162, 322, 20);
		frmHyundai.getContentPane().add(emailField);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setBounds(10, 193, 85, 14);
		frmHyundai.getContentPane().add(lblContactNo);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(102, 190, 322, 20);
		frmHyundai.getContentPane().add(contactField);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Save();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 265, 89, 35);
		frmHyundai.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(112, 265, 89, 35);
		frmHyundai.getContentPane().add(btnClear);	
		
		JLabel lblNewLabel_2 = new JLabel("Tin No.");
		lblNewLabel_2.setBounds(10, 224, 85, 14);
		frmHyundai.getContentPane().add(lblNewLabel_2);
		
		tinField = new JTextField();
		tinField.setColumns(10);
		tinField.setBounds(102, 221, 322, 20);
		frmHyundai.getContentPane().add(tinField);
		
		frmHyundai.pack();
		
	}
	
	private void clear() {
		fnameField.setText(null);
		lnameField.setText(null);
		mnameField.setText(null);
		addressField.setText(null);
		emailField.setText(null);
		contactField.setText(null);
		tinField.setText(null);
	}
	
	
	private void Save() throws SQLException {
		// TODO Auto-generated method stub
		String fn = fnameField.getText().trim().replaceAll("\\s", "");
		String ln = lnameField.getText().trim().replaceAll("\\s", "");
		String mm = mnameField.getText().trim().replaceAll("\\s", "");
		String ads = addressField.getText().trim().replaceAll("\\s", "");
		String email = emailField.getText().trim().replaceAll("\\s", "");
		String contact = contactField.getText().trim().replaceAll("\\s", "");
		String tin = tinField.getText().trim().replaceAll("\\s", "");
		
		Admin_connect ad = new Admin_connect();
		ad.pst = ad.con.prepareStatement("insert into customer_information_records (firstname, lastname, middle, address, email, contact, tin) values (?,?,?,?,?,?,?)");
		ad.pst.setString(1, fn);
		ad.pst.setString(2, ln);
		ad.pst.setString(3, mm);
		ad.pst.setString(4, ads);
		ad.pst.setString(5, email);
		ad.pst.setString(6, contact);
		ad.pst.setString(7, tin);
		int x = ad.pst.executeUpdate();
		if (x==1) {
			JOptionPane.showMessageDialog(null, "Customer Record Save!", "Hyundai",JOptionPane.INFORMATION_MESSAGE);
			ad.con.close();
			clear();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error Saving Customer Record.","Hyundai",JOptionPane.ERROR_MESSAGE);
		}	
	}
}
