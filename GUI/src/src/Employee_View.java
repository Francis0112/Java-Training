package src;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;



public class Employee_View extends JFrame {
	public Employee_View() throws SQLException {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.clearSelection();
			}
		});
		setResizable(false);
		setTitle("Employee View");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.clearSelection();
			}
		});
		panel.setBorder(new TitledBorder(null, "View Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 858, 351);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 21, 846, 290);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		
		JButton add_btn = new JButton("ADD");
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Employee_UI();
			}
		});
		add_btn.setBounds(6, 315, 107, 30);
		panel.add(add_btn);
		add_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton delete_btn = new JButton("DELETE");
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					delete_data();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete_btn.setBounds(123, 315, 107, 30);
		panel.add(delete_btn);
		delete_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton update_btn = new JButton("UPDATE");
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch_data();
			}
		});
		update_btn.setBounds(240, 315, 107, 30);
		panel.add(update_btn);
		update_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton load_btn_1 = new JButton("LOAD");
		load_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					view_data();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		load_btn_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		load_btn_1.setBounds(357, 315, 107, 30);
		panel.add(load_btn_1);
		view_data();
		setSize(894,411);
		setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable table;
	
	private static void fetch_data() {
		if (table.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Select a record in the table.");
		}
		else {
			String emp_id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			String fname = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
			String lname = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
			String email = table.getModel().getValueAt(table.getSelectedRow(), 3).toString();
			String contact = table.getModel().getValueAt(table.getSelectedRow(), 4).toString();
			String position = table.getModel().getValueAt(table.getSelectedRow(), 5).toString();
			String salary = table.getModel().getValueAt(table.getSelectedRow(), 6).toString();
			Update_Employee ue = new Update_Employee();
			ue.setID(emp_id);
			ue.setFname(fname);
			ue.setLname(lname);
			ue.setEmail(email);
			ue.setContact(contact);
			ue.setPosition(position);
			ue.setSalary(salary);
		}
	}
	
	private static void delete_data() throws SQLException {
		if (table.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Select a record in the table.");
		}
		else {
			String value = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			int x = Integer.parseInt(value);
			
			if (JOptionPane.showConfirmDialog(null, "Are you sure to Delete this record?","warning",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				Admin_connect ad = new Admin_connect();
				ad.pst = ad.con.prepareStatement("delete from employee where emp_id=?");
				ad.pst.setInt(1, x);
				ad.pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Record have been Deleted!");
			}
		}
	}
	
	private static void view_data() throws SQLException {
		Admin_connect ad = new Admin_connect();
		ad.pst = ad.con.prepareStatement("select * from employee");
		ad.rs = ad.pst.executeQuery();
		String[] cols = {"Employee ID","First name", "last name", "Email","Contact","Position","Salary"};
		DefaultTableModel model = new DefaultTableModel(cols,0);
		while (ad.rs.next()) {
			String em_id = ad.rs.getString("emp_id");
			String fname = ad.rs.getString("firstname");
			String lname = ad.rs.getString("lastname");
			String email = ad.rs.getString("email");
			String contact = ad.rs.getString("contact");
			String position = ad.rs.getString("position");
			String salary = ad.rs.getString("salary");
			String[] data = {em_id,fname,lname,email,contact,position,salary};
			model.addRow(data);
		}
		table.setModel(model);
	}
}
