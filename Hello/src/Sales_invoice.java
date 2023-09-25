import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sales_invoice extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField soldField;
	private JTextField addressField;
	private JTextField businessField;
	private JTextField preparedField;
	private JTextField CheckedField;
	private JTextField ApprovedField;
	private JTextField tinField;
	private JTextField TypeofSaleField;
	private JTextField srpField;
	private JTextField discountField;
	private JTextField netField;
	private JTextField vatField;
	private JTextField totalField;
	private JTextField downpaymentField;
	private JTextField tradeinField;
	private JTextField balanceToBeFinanceField;
	private JTextField monthsField;
	private JTextField amountField;
	private JTextField generalManagerField;
	private JTextField CustomerField;
	private JFrame frmHyundaiBacoor;
	
	
	public Sales_invoice() {		
		
		frmHyundaiBacoor = new JFrame("Hyundai Bacoor");
		frmHyundaiBacoor.setTitle("Hyundai");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(105, 178, 293, 20);
		dateChooser.setCalendar(Calendar.getInstance());
		frmHyundaiBacoor.getContentPane().add(dateChooser);
		
		Date d = dateChooser.getDate();
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
//		String today = df.format(d);
		
		JLabel lblNewLabel = new JLabel("Sold To:");
		lblNewLabel.setBounds(22, 101, 46, 24);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setBounds(22, 128, 63, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1);
		
		soldField = new JTextField();
		soldField.setBounds(73, 100, 325, 20);
		frmHyundaiBacoor.getContentPane().add(soldField);
		soldField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(73, 125, 325, 20);
		frmHyundaiBacoor.getContentPane().add(addressField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Business Name:");
		lblNewLabel_1_1.setBounds(22, 156, 96, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_1);
		
		businessField = new JTextField();
		businessField.setColumns(10);
		businessField.setBounds(118, 150, 280, 20);
		frmHyundaiBacoor.getContentPane().add(businessField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date: ");
		lblNewLabel_1_2.setBounds(22, 178, 46, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Prepared By:");
		lblNewLabel_1_3.setBounds(22, 206, 92, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_3);
		
		preparedField = new JTextField();
		preparedField.setColumns(10);
		preparedField.setBounds(105, 203, 293, 20);
		frmHyundaiBacoor.getContentPane().add(preparedField);
		
		JLabel lblNewLabel_1_4 = new JLabel("Checked By:");
		lblNewLabel_1_4.setBounds(22, 231, 92, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_4);
		
		CheckedField = new JTextField();
		CheckedField.setColumns(10);
		CheckedField.setBounds(105, 228, 293, 20);
		frmHyundaiBacoor.getContentPane().add(CheckedField);
		
		JLabel lblNewLabel_1_5 = new JLabel("Approved By:");
		lblNewLabel_1_5.setBounds(22, 256, 96, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_5);
		
		ApprovedField = new JTextField();
		ApprovedField.setColumns(10);
		ApprovedField.setBounds(103, 253, 295, 20);
		frmHyundaiBacoor.getContentPane().add(ApprovedField);
		
		JLabel lblNewLabel_1_6 = new JLabel("Tin #:");
		lblNewLabel_1_6.setBounds(22, 281, 46, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_6);
		
		tinField = new JTextField();
		tinField.setColumns(10);
		tinField.setBounds(73, 278, 325, 20);
		frmHyundaiBacoor.getContentPane().add(tinField);
		
		JLabel lblNewLabel_1_7 = new JLabel("Type of Sale:");
		lblNewLabel_1_7.setBounds(22, 306, 96, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_7);
		
		TypeofSaleField = new JTextField();
		TypeofSaleField.setColumns(10);
		TypeofSaleField.setBounds(103, 303, 295, 20);
		frmHyundaiBacoor.getContentPane().add(TypeofSaleField);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Date d = dateChooser.getDate();
//				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				
				String s1 = soldField.getText().trim().replaceAll("\\s", "");
				String s2 = addressField.getText().trim().replaceAll("\\s", "");
				String s3 = businessField.getText().trim().replaceAll("\\s", "");
				String s4 = df.format(d);
				String s5 = preparedField.getText().trim().replaceAll("\\s", "");
				String s6 = CheckedField.getText().trim().replaceAll("\\s", "");
				String s7 = ApprovedField.getText().trim().replaceAll("\\s", "");
				String s8 = tinField.getText().trim().replaceAll("\\s", "");
				String s9 = TypeofSaleField.getText().trim().replaceAll("\\s", "");
				String s10 = srpField.getText().trim().replaceAll("\\s", "");
				String s11 = discountField.getText().trim().replaceAll("\\s", "");
				String s12 = totalField.getText().trim().replaceAll("\\s", "");
				String s13 = vatField.getText().trim().replaceAll("\\s", "");
				String s14 = totalField.getText().trim().replaceAll("\\s", "");
				String s15 = downpaymentField.getText().trim().replaceAll("\\s", "");
				String s16 = tradeinField.getText().trim().replaceAll("\\s", "");
				String s17 = balanceToBeFinanceField.getText().trim().replaceAll("\\s", "");
				String s18 = monthsField.getText().trim().replaceAll("\\s", "");
				String s19 = amountField.getText().trim().replaceAll("\\s", "");
				String s20 = generalManagerField.getText().trim().replaceAll("\\s", "");
				String s21 = CustomerField.getText().trim().replaceAll("\\s", "");
				
				Admin_connect ad = new Admin_connect();
//				ad.pst = ad.con.prepareStatement("insert into sales_invoice_records (sold_to, address, business_name, date, prepared_by, checked_by, approved_by, tin, type_of_sale, srp(net_vat), discount, total_net_sales, vat, total_sales, down_payment, trade_in, balance_to_be_finance, months, amount, general_manager, customer) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				try {
				ad.pst = ad.con.prepareStatement("INSERT INTO `sales_invoice_records`(`sold_to`, `address`, `business_name`, `date`, `prepared_by`, `checked_by`, `approved_by`, `tin`, `type_of_sale`, `srp(net_vat)`, `discount`, `total_net_sales`, `vat`, `total_sales`, `down_payment`, `trade_in`, `balance_to_be_finance`, `months`, `amount`, `general_manager`, `customer`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ad.pst.setString(1, s1);
				ad.pst.setString(2, s2);
				ad.pst.setString(3, s3);
				ad.pst.setString(4, s4);
				ad.pst.setString(5, s5);
				ad.pst.setString(6, s6);
				ad.pst.setString(7, s7);
				ad.pst.setString(8, s8);
				ad.pst.setString(9, s9);
				ad.pst.setString(10, s10);
				ad.pst.setString(11, s11);
				ad.pst.setString(12, s12);
				ad.pst.setString(13, s13);
				ad.pst.setString(14, s14);
				ad.pst.setString(15, s15);
				ad.pst.setString(16, s16);
				ad.pst.setString(17, s17);
				ad.pst.setString(18, s18);
				ad.pst.setString(19, s19);
				ad.pst.setString(20, s20);
				ad.pst.setString(21, s21);
				int x = ad.pst.executeUpdate();
				if (x==1) {
					JOptionPane.showMessageDialog(null, "Sales Invoice Vehicle Save!", "Hyundai",JOptionPane.INFORMATION_MESSAGE);
					clear();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error Saving Sales Invoice Vehicle.","Hyundai",JOptionPane.ERROR_MESSAGE);
				}
			}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Database Error!","Hyundai",JOptionPane.ERROR_MESSAGE);
					System.out.println(e1);
				}
			}
		});
		
		btnNewButton.setBounds(22, 492, 89, 23);
		frmHyundaiBacoor.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Sales Invoice (Vehicle)");
		lblNewLabel_2.setBounds(20, 60, 143, 47);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Settlement");
		lblNewLabel_2_1.setBounds(408, 76, 89, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnCancel = new JButton("Clear");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(132, 492, 89, 23);
		frmHyundaiBacoor.getContentPane().add(btnCancel);
		
		TextArea desc = new TextArea();
		desc.setBounds(22, 369, 782, 99);
		frmHyundaiBacoor.getContentPane().add(desc);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Description");
		lblNewLabel_2_2_1_1.setBounds(22, 349, 429, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("SRP (net VAT)");
		lblNewLabel_3.setBounds(408, 115, 89, 24);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_3);
		
		srpField = new JTextField();
		srpField.setColumns(10);
		srpField.setBounds(500, 117, 165, 20);
		frmHyundaiBacoor.getContentPane().add(srpField);
		
		JLabel lblNewLabel_1_8 = new JLabel("Discount");
		lblNewLabel_1_8.setBounds(408, 142, 89, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_8);
		
		discountField = new JTextField();
		discountField.setColumns(10);
		discountField.setBounds(500, 142, 165, 20);
		frmHyundaiBacoor.getContentPane().add(discountField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total Net Sales");
		lblNewLabel_1_1_1.setBounds(408, 167, 89, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_1_1);
		
		netField = new JTextField();
		netField.setColumns(10);
		netField.setBounds(500, 167, 165, 20);
		frmHyundaiBacoor.getContentPane().add(netField);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("VAT");
		lblNewLabel_1_2_1.setBounds(408, 192, 89, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_2_1);
		
		vatField = new JTextField();
		vatField.setColumns(10);
		vatField.setBounds(500, 192, 165, 20);
		frmHyundaiBacoor.getContentPane().add(vatField);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Total Sales");
		lblNewLabel_1_3_1.setBounds(408, 217, 89, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_3_1);
		
		totalField = new JTextField();
		totalField.setColumns(10);
		totalField.setBounds(500, 217, 165, 20);
		frmHyundaiBacoor.getContentPane().add(totalField);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Downpayment");
		lblNewLabel_1_4_1.setBounds(408, 242, 89, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_4_1);
		
		downpaymentField = new JTextField();
		downpaymentField.setColumns(10);
		downpaymentField.setBounds(500, 242, 165, 20);
		frmHyundaiBacoor.getContentPane().add(downpaymentField);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Trade-in");
		lblNewLabel_1_5_1.setBounds(408, 267, 89, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_5_1);
		
		tradeinField = new JTextField();
		tradeinField.setColumns(10);
		tradeinField.setBounds(500, 267, 165, 20);
		frmHyundaiBacoor.getContentPane().add(tradeinField);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Balance to be Finance:");
		lblNewLabel_1_6_1.setBounds(408, 295, 143, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_6_1);
		
		balanceToBeFinanceField = new JTextField();
		balanceToBeFinanceField.setColumns(10);
		balanceToBeFinanceField.setBounds(534, 292, 131, 20);
		frmHyundaiBacoor.getContentPane().add(balanceToBeFinanceField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Months:");
		lblNewLabel_3_1.setBounds(675, 90, 46, 24);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_3_1);
		
		monthsField = new JTextField();
		monthsField.setColumns(10);
		monthsField.setBounds(675, 114, 199, 20);
		frmHyundaiBacoor.getContentPane().add(monthsField);
		
		JLabel lblNewLabel_1_8_1 = new JLabel("Amount:");
		lblNewLabel_1_8_1.setBounds(675, 136, 96, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_8_1);
		
		amountField = new JTextField();
		amountField.setColumns(10);
		amountField.setBounds(675, 153, 199, 20);
		frmHyundaiBacoor.getContentPane().add(amountField);
		
		JLabel lblNewLabel_3_2 = new JLabel("General Manager:");
		lblNewLabel_3_2.setBounds(675, 203, 137, 24);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_3_2);
		
		generalManagerField = new JTextField();
		generalManagerField.setColumns(10);
		generalManagerField.setBounds(675, 228, 199, 20);
		frmHyundaiBacoor.getContentPane().add(generalManagerField);
		
		JLabel lblNewLabel_1_8_2 = new JLabel("Customer:");
		lblNewLabel_1_8_2.setBounds(675, 256, 96, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_1_8_2);
		
		CustomerField = new JTextField();
		CustomerField.setColumns(10);
		CustomerField.setBounds(675, 278, 199, 20);
		frmHyundaiBacoor.getContentPane().add(CustomerField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Payable in:");
		lblNewLabel_2_1_1.setBounds(676, 76, 69, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Approved by:");
		lblNewLabel_2_1_2.setBounds(675, 178, 70, 14);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_2_1_2);
		frmHyundaiBacoor.setVisible(true);
		frmHyundaiBacoor.getContentPane().setLayout(null);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				print_bro();
			}
		});
		btnPrint.setBounds(245, 492, 89, 23);
		frmHyundaiBacoor.getContentPane().add(btnPrint);
		
		JLabel lblNewLabel_4 = new JLabel("Sales Invoice Vehicle");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(22, 23, 376, 38);
		frmHyundaiBacoor.getContentPane().add(lblNewLabel_4);
		
		
		JButton btnNewButton_1 = new JButton("buhay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String today = df.format(d);
				System.out.println(today);
			}
		});
		btnNewButton_1.setBounds(351, 492, 89, 23);
		frmHyundaiBacoor.getContentPane().add(btnNewButton_1);
		frmHyundaiBacoor.setPreferredSize(new Dimension(900,600));
		
		frmHyundaiBacoor.pack();
	}
	
	private void clear() {
		soldField.setText(null);
		addressField.setText(null);
		businessField.setText(null);
		preparedField.setText(null);
		CheckedField.setText(null);
		ApprovedField.setText(null);
		tinField.setText(null);
		TypeofSaleField.setText(null);
		srpField.setText(null);
		discountField.setText(null);
		netField.setText(null);
		vatField.setText(null);
		totalField.setText(null);
		downpaymentField.setText(null);
		tradeinField.setText(null);
		balanceToBeFinanceField.setText(null);
		monthsField.setText(null);
		amountField.setText(null);
		generalManagerField.setText(null);
		CustomerField.setText(null);
//		desc.setText("")
	}
	
	private void print_bro() {
		
		
		
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setJobName("hyundai Bacoor");
			job.setPrintable(new Printable() {
				
				@Override
				public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
					// TODO Auto-generated method stub
					if (pageIndex > 0) {
						return Printable.NO_SUCH_PAGE;
					}
						graphics.drawString("Sold to: " + soldField.getText(), 100, 100);
						graphics.drawString("Address: " + addressField.getText(), 100, 120);
						graphics.drawString("Business Name: " + businessField.getText(), 100, 140);
//						graphics.drawString("Date: " + today, 100, 160);
						graphics.drawString("Prepared by: " + soldField.getText(), 100, 180);
						graphics.drawString("Checked by: " + soldField.getText(), 100, 200);
						graphics.drawString("Approved by: " + soldField.getText(), 100, 220);
						graphics.drawString("Tin #: " + soldField.getText(), 100, 240);
						graphics.drawString("Type of Sale: " + soldField.getText(), 100, 260);
						graphics.drawString("Sold to: Sale" + soldField.getText(), 100, 280);
						graphics.drawString("SRP(Net Vat): " + soldField.getText(), 100, 300);
						graphics.drawString("Discount: " + soldField.getText(), 100, 320);
						graphics.drawString("total Net Sales: " + soldField.getText(), 100, 340);
						graphics.drawString("DownPayment: " + soldField.getText(), 100, 360);
						graphics.drawString("Trade in: " + soldField.getText(), 100, 380);
						graphics.drawString("Balance to be Finance: " + soldField.getText(), 100, 400);
						graphics.drawString("Months: " + soldField.getText(), 100, 420);
						graphics.drawString("Amount: " + soldField.getText(), 100, 460);
						graphics.drawString("General Manager: " + soldField.getText(), 100, 480);
						graphics.drawString("Customer: " + soldField.getText(), 100, 500);
						return Printable.PAGE_EXISTS;
				}
			});
			if (job.printDialog() == false) {
				return;
			}
			job.print();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
