package src;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField user_text;
	private JPasswordField pass_text;
	private JLabel result_label;
	
	
	private void log() throws SQLException {
		Admin_connect ad = new Admin_connect();
		ad.pst = ad.con.prepareStatement("select username, password from admin where username=? and password=?");
		ad.pst.setString(1, user_text.getText());
		ad.pst.setString(2, pass_text.getText());
		ad.rs = ad.pst.executeQuery();
		if(ad.rs.next()) {
			result_label.setText("Welcome "+user_text.getText()+"! hackerman System.");
			JOptionPane.showMessageDialog(null, "Welcome "+user_text.getText()+"! Hackerman System.");
		}
		else {
			System.out.println("Invalid login");
			user_text.setText("");
			pass_text.setText("");
			result_label.setText("Invalid login");
			user_text.grabFocus();
		}
	}
	
	private void clear_text() {
		user_text.setText("");
		pass_text.setText("");
		result_label.setText("");
		user_text.grabFocus();
	}
	
	
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setTitle("Hackerman Login");
		getContentPane().setLayout(null);
		setSize(349,349);
		
		JLabel user_label = new JLabel("Username:");
		user_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user_label.setBounds(10, 26, 102, 27);
		getContentPane().add(user_label);
		
		JLabel pass_label = new JLabel("Password:");
		pass_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass_label.setBounds(10, 82, 102, 27);
		getContentPane().add(pass_label);
		
		user_text = new JTextField();
		user_text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user_text.setBounds(10, 53, 310, 32);
		getContentPane().add(user_text);
		user_text.setColumns(10);
		
		pass_text = new JPasswordField();
		pass_text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						log();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		pass_text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass_text.setBounds(10, 109, 310, 32);
		getContentPane().add(pass_text);
		
		JButton login_btn = new JButton("LOGIN");
		login_btn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						log();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		login_btn.addActionListener(e -> {
			try {
				log();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		login_btn.setBounds(10, 212, 310, 38);
		getContentPane().add(login_btn);
		
		JButton clear_btn = new JButton("CLEAR");
		clear_btn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				clear_text();
			}
		});
		clear_btn.addActionListener(e -> clear_text());
		clear_btn.setBounds(10, 261, 310, 38);
		getContentPane().add(clear_btn);
		
		result_label = new JLabel("");
		result_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		result_label.setBounds(10, 174, 310, 27);
		getContentPane().add(result_label);
		setVisible(true);
	}
}
