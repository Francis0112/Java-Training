package src;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField user_text;
	private JPasswordField pass_text;
	private JLabel result_label;
		
	private void log() throws SQLException {
		try {
			Admin_connect ad = new Admin_connect();
			ad.pst = ad.con.prepareStatement("select username, password from admin where username=? and password=PASSWORD(?)");
			String username = user_text.getText().trim();
			String password = pass_text.getText().trim();
			ad.pst.setString(1, username);
			ad.pst.setString(2, password);
			ad.rs = ad.pst.executeQuery();
			if(ad.rs.next()) {
				String name = ad.rs.getString("username");
				if (name.equals(username)) {
					result_label.setText("Welcome " + user_text.getText() + "! hackerman System.");
					System.out.println("Welcome "+username+"! Hackerman System.");
					JOptionPane.showMessageDialog(null, "Welcome " + user_text.getText() + "! Hackerman System.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid login");
					System.out.println("Invalid login");
					user_text.setText("");
					pass_text.setText("");
					result_label.setText("Invalid login");
					user_text.grabFocus();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid login");
				System.out.println("Invalid login");
				user_text.setText("");
				pass_text.setText("");
				result_label.setText("Invalid login");
				user_text.grabFocus();
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Something went wrong. Error!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Database lost Connection. Error!");
		}
	}
	
	private void clear_text() {
		user_text.setText("");
		pass_text.setText("");
		result_label.setText("");
		user_text.grabFocus();
	}
	
	
	
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setTitle("Hackerman Login");
		getContentPane().setLayout(null);
		setSize(349,384);
		
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
		
		JLabel Register_label = new JLabel("Register");
		Register_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton()==MouseEvent.BUTTON1) {
					new Register();
				}
			}
		});
		Register_label.setForeground(Color.BLUE);
		Register_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Register_label.setBounds(10, 310, 310, 27);
		getContentPane().add(Register_label);
		setVisible(true);
	}
}
