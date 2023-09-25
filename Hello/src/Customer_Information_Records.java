import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.ScrollPane;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_Information_Records extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField searchField;
	private static JTable table;
	private static DefaultTableModel model;
	
	
	
	public Customer_Information_Records() throws SQLException {

		
		JFrame frmHyundai = new JFrame();
		frmHyundai.setTitle("Hyundai");
		frmHyundai.setVisible(true);
		frmHyundai.getContentPane().setLayout(null);
		frmHyundai.setPreferredSize(new Dimension(936,430));
		
		JLabel lblNewLabel = new JLabel("Customer Information Records");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 36, 299, 47);
		frmHyundai.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setBounds(10, 81, 74, 14);
		frmHyundai.getContentPane().add(lblNewLabel_1);
		
		searchField = new JTextField();
		searchField.setBounds(65, 78, 230, 20);
		frmHyundai.getContentPane().add(searchField);
		searchField.setColumns(10);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.setBounds(645, 77, 89, 23);
		frmHyundai.getContentPane().add(btnNewButton);
		
		JButton btnReloadDatabase = new JButton("Reload Database");
		btnReloadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					view_data();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReloadDatabase.setBounds(744, 77, 164, 23);
		frmHyundai.getContentPane().add(btnReloadDatabase);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 898, 274);
		frmHyundai.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		view_data();
		
		frmHyundai.pack();
	}
	private static void view_data() throws SQLException {
		Admin_connect ad = new Admin_connect();
		ad.pst = ad.con.prepareStatement("select * from customer_information_records");
		ad.rs = ad.pst.executeQuery();
		String[] cols = {"ID","First name", "Last name", "Middle name", "Address", "Email","Contact","Tin"};
		DefaultTableModel model = new DefaultTableModel(cols,0);
		while (ad.rs.next()) {
			String id = ad.rs.getString("id");
			String fname = ad.rs.getString("firstname");
			String lname = ad.rs.getString("lastname");
			String middle = ad.rs.getString("middle");
			String address = ad.rs.getString("address");
			String email = ad.rs.getString("email");
			String contact = ad.rs.getString("contact");
			String tin = ad.rs.getString("tin");
			String[] data = {id,fname,lname,middle,address,email,contact,tin};
			model.addRow(data);
		}
		table.setModel(model);
	}
}
