import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Login extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JFrame frmHyundai;

	
	
	@SuppressWarnings("rawtypes")
	public Login() {
		setTitle("Hyundai");
		getContentPane().setLayout(null);
		
		frmHyundai = new JFrame();
		frmHyundai.setTitle("Hyundai");
		frmHyundai.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frmHyundai.setVisible(true);
		frmHyundai.getContentPane().setLayout(null);
		frmHyundai.setPreferredSize(new Dimension(309,300));
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(30, 96, 63, 14);
		frmHyundai.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 140, 63, 14);
		frmHyundai.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setToolTipText("enter username");
		textField.setBounds(97, 93, 167, 20);
		frmHyundai.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login_now();
				}
			}
		});
		passwordField.setToolTipText("enter password");
		passwordField.setBounds(97, 137, 167, 20);
		frmHyundai.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login_now();
			}
		});
		btnNewButton.setBounds(30, 209, 120, 41);
		frmHyundai.getContentPane().add(btnNewButton);
		

		JLabel lblNewLabel_1 = new JLabel("Hyundai Bacoor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 39, 234, 46);
		frmHyundai.getContentPane().add(lblNewLabel_1);
		
		String options[] = {"admin", "users"};
		JComboBox comboBox = new JComboBox(options);
		comboBox.setBounds(30, 165, 89, 22);
		frmHyundai.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				register();
			}

		});
		btnNewButton_1.setBounds(160, 209, 104, 41);
		frmHyundai.getContentPane().add(btnNewButton_1);
		frmHyundai.pack();	
	}
	
	private void login_now() {
		
		String username = textField.getText().trim();
		char[] np = passwordField.getPassword();
		String password = String.valueOf(np);
		
		
		try {
			
			Admin_connect ad = new Admin_connect();
			ad.pst = ad.con.prepareStatement("select username and password from users where username=? and password=?");
			ad.pst.setString(1, username);
			ad.pst.setString(2, password);
			ad.rs = ad.pst.executeQuery();
			
			if (ad.rs.next()) {
				new MAIN_UI();
				frmHyundai.dispose();  
				ad.con.close();
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid username or password. ", "Hyundai", JOptionPane.WARNING_MESSAGE);
				textField.setText("");
				passwordField.setText("");
				textField.requestFocus();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	private void register() {
		new Register();
	}
}
