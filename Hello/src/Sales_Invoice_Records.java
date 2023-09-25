import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Sales_Invoice_Records extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable table;
	private JTextField searchField;
	public Sales_Invoice_Records() throws SQLException {
		
		
		JFrame frmHyundai = new JFrame();
		frmHyundai.setTitle("Hyundai");
		frmHyundai.setVisible(true);
		frmHyundai.getContentPane().setLayout(null);
		frmHyundai.setPreferredSize(new Dimension(1200,582));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 128, 919, 406);
//		frmHyundai.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 125, 1164, 407);
		frmHyundai.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Sales Invoice (Vehicle) Records");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 32, 334, 36);
		frmHyundai.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setBounds(10, 100, 81, 14);
		frmHyundai.getContentPane().add(lblNewLabel_1);
		
		searchField = new JTextField();
		searchField.setBounds(52, 97, 227, 20);
		frmHyundai.getContentPane().add(searchField);
		searchField.setColumns(10);
		
		JButton btnNewButton = new JButton("Reload Database");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					view_data();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(1025, 91, 149, 23);
		frmHyundai.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setBounds(903, 91, 112, 23);
		frmHyundai.getContentPane().add(btnNewButton_1);
		
		view_data();

		frmHyundai.pack();
	}
	private static void view_data() throws SQLException {
		Admin_connect ad = new Admin_connect();
		ad.pst = ad.con.prepareStatement("select * from sales_invoice_records");
		ad.rs = ad.pst.executeQuery();
		String[] cols = {"ID","Sold To", "Address", "Business Name", "Date", "Prepared By","Checked By","Approved By","Tin","Type Of Sale","SRP(Net Vat)","Discount","Total Net Sales","Vat","Total Sales","Down Payment","Trade in","Balance To Be Finance","Months","Amount","General Manager","Customer"};
		DefaultTableModel model = new DefaultTableModel(cols,0);
		while (ad.rs.next()) {
			String id = ad.rs.getString("id");
			String sold_to = ad.rs.getString("sold_to");
			String address = ad.rs.getString("address");
			String business_name = ad.rs.getString("business_name");
			String date = ad.rs.getString("date");
			String prepared_by = ad.rs.getString("prepared_by");
			String checked_by = ad.rs.getString("checked_by");
			String approved_by = ad.rs.getString("approved_by");
			String tin = ad.rs.getString("tin");
			String type_of_sale = ad.rs.getString("type_of_sale");
			String srp = ad.rs.getString("srp(net_vat)");
			String discount = ad.rs.getString("discount");
			String total_net_sales = ad.rs.getString("total_net_sales");
			String vat = ad.rs.getString("vat");
			String total_sales = ad.rs.getString("total_sales");
			String down_payment = ad.rs.getString("down_payment");
			String tradein = ad.rs.getString("trade_in");
			String balance_to_be_finance = ad.rs.getString("balance_to_be_finance");
			String months = ad.rs.getString("months");
			String amount = ad.rs.getString("amount");
			String general_manager = ad.rs.getString("general_manager");
			String customer = ad.rs.getString("customer");
			String[] data = {id, sold_to, address, business_name, date, prepared_by, checked_by, approved_by, tin, type_of_sale, srp,discount, total_net_sales, vat, total_sales, down_payment, tradein, balance_to_be_finance, months, amount, general_manager, customer};
			model.addRow(data);
		}
		table.setModel(model);
	}
}
