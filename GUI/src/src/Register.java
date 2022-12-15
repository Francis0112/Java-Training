package src;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Register extends JFrame {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username_textbox;
	private JPasswordField password_textbox;
	private JPasswordField conf_password_textbox;
	
	private void submit() throws SQLException {
		String user = username_textbox.getText().trim().replaceAll("\\s", "");
		String pass = password_textbox.getText().trim().replaceAll("\\s", "");
		String conf_pass = conf_password_textbox.getText().trim().replaceAll("\\s", "");
		
		Admin_connect ad = new Admin_connect();
		ad.pst = ad.con.prepareStatement("select username from admin where username = ?");
		ad.pst.setString(1, user);
		ad.rs = ad.pst.executeQuery();
		if (ad.rs.next()) {
			JOptionPane.showMessageDialog(null, "Username Already Taken. Try again.");
			System.out.println("Username Already Taken. Try again.");
		}
		else if (!pass.equals(conf_pass)) {
			JOptionPane.showMessageDialog(null, "Password do not match!");
			System.out.println("Password do not match!");
		}
		else {
			ad.pst = ad.con.prepareStatement("insert into admin (username, password) values (?,PASSWORD(?))");
			ad.pst.setString(1, user);
			ad.pst.setString(2, pass);
			int x = ad.pst.executeUpdate();
			if (x==1) {
				JOptionPane.showMessageDialog(null, "Registration Completed!");
				System.out.println("Registration Completed!");
				clear();
			}
		}
	}

	
	private void clear() {
		username_textbox.setText("");
		password_textbox.setText("");
		conf_password_textbox.setText("");
		username_textbox.grabFocus();
	}
	
	public Register() {
		setResizable(false);
		setTitle("Hackerman System");
		setSize(452,307);
		getContentPane().setLayout(null);
		
		JLabel username_label = new JLabel("Username:");
		username_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username_label.setBounds(10, 11, 129, 29);
		getContentPane().add(username_label);
		
		username_textbox = new JTextField();
		username_textbox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username_textbox.setBounds(10, 40, 414, 29);
		getContentPane().add(username_textbox);
		username_textbox.setColumns(10);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password_label.setBounds(10, 80, 129, 29);
		getContentPane().add(password_label);
		
		password_textbox = new JPasswordField();
		password_textbox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password_textbox.setBounds(10, 111, 414, 29);
		getContentPane().add(password_textbox);
		
		JLabel Conf_password_label = new JLabel("Confirm Password:");
		Conf_password_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Conf_password_label.setBounds(10, 151, 129, 29);
		getContentPane().add(Conf_password_label);
		
		conf_password_textbox = new JPasswordField();
		conf_password_textbox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						submit();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		conf_password_textbox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		conf_password_textbox.setBounds(10, 182, 414, 29);
		getContentPane().add(conf_password_textbox);
		
		JButton submit_btn = new JButton("Submit");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					submit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		submit_btn.setBounds(10, 222, 89, 38);
		getContentPane().add(submit_btn);
		
		JButton clear_btn = new JButton("Clear");
		clear_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		clear_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clear_btn.setBounds(109, 222, 89, 38);
		getContentPane().add(clear_btn);
		setVisible(true);
	}
}
