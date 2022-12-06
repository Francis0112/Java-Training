package src;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField user_text;
	private JTextField password_text;
	
	public Login() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JLabel username = new JLabel("username");
		getContentPane().add(username);
		
		user_text = new JTextField();
		getContentPane().add(user_text);
		user_text.setColumns(10);
		
		JLabel password = new JLabel("Password");
		getContentPane().add(password);
		
		password_text = new JTextField();
		getContentPane().add(password_text);
		password_text.setColumns(10);
		this.setTitle("Hackerman page 4");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(username);
		this.add(user_text);
		this.add(password);
		this.add(password_text);
		this.pack();
		this.setVisible(true);
	}

}
