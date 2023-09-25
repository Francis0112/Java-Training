import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MAIN_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MAIN_UI() {
		
		JFrame frmHyundai = new JFrame();
		frmHyundai.setTitle("Hyundai");
		frmHyundai.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frmHyundai.setVisible(true);
		frmHyundai.getContentPane().setLayout(null);
		frmHyundai.setPreferredSize(new Dimension(400,400));
		
		String[] operations = {"Costumer Information","Vehicles","Sales Invoice","Sales Proposal", "Delivery Receipt","S.I (Parts & Accessories)","Repair Quote","Work Order","Service Invoice"};
		JComboBox comboBox = new JComboBox(operations);
		comboBox.setBounds(31, 132, 320, 32);
		frmHyundai.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Hyundai Bacoor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(92, 38, 207, 46);
		frmHyundai.getContentPane().add(lblNewLabel);
		
		
		String[] tables = {"Costumer Information Records","Vehicle Records","Sales Invoice records", "Sales Proposal Records", "Delivery Receipt Records", "S.I (Parts & Accessories) Records","Repair Quote Records","Work Order Records","Service Invoice Records"};
		JComboBox comboBox_1 = new JComboBox(tables);
		comboBox_1.setBounds(31, 245, 320, 38);
		frmHyundai.getContentPane().add(comboBox_1);
		
		frmHyundai.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frmHyundai.setVisible(true);
		frmHyundai.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Operations:");
		lblNewLabel_2.setBounds(31, 107, 73, 14);
		frmHyundai.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = comboBox.getSelectedIndex();
				switch (op) {
				case 0: {
					System.out.println("Customer Information");
					new Customer_Information();
					break;
				}
				case 1: {
					System.out.println("Vehicles");
					break;
				}
				case 2: {
					System.out.println("Sales Invoice");
					new Sales_invoice();
					break;
				}
				case 3: {
					System.out.println("Sales Proposal");
					break;
				}
				case 4: {
					System.out.println("Delivery Receipt");
					break;
				}
				case 5: {
					System.out.println("Sales Invoice (Parts And Accessories)");
					break;
				}
				case 6: {
					System.out.println("Repair Quote");
					break;
				}
				case 7: {
					System.out.println("Work Order");
					break;
				}
				case 8: {
					System.out.println("Service Invoice");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + op);
				}
			}
		});
		btnNewButton.setBounds(31, 175, 110, 32);
		frmHyundai.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int re = comboBox_1.getSelectedIndex();
				switch(re) {
				case 0:
					System.out.println("Customer Information Records");
					try {
						new Customer_Information_Records();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 1:
					System.out.println("Vehicle Records");
					break;
				case 2:
					System.out.println("Sales Invoice Records");
					try {
						new Sales_Invoice_Records();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Sales Proposal Records");
					break;
				case 4:
					System.out.println("Delivery Receipt Records");
					break;
				case 5:
					System.out.println("Sales Invoice (Parts And Accessories) Records");
					break;
				case 6:
					System.out.println("Repair Quote Records");
					break;
				case 7:
					System.out.println("Work Order Records");
					break;
				case 8:
					System.out.println("Service Invoice Records");
					break;
				}	
			}
		});
		btnNewButton_1.setBounds(31, 294, 110, 32);
		frmHyundai.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Records:");
		lblNewLabel_1.setBounds(31, 218, 73, 14);
		frmHyundai.getContentPane().add(lblNewLabel_1);
		frmHyundai.pack();
	}
}
