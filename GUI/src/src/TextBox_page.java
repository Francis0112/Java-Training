package src;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextBox_page extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn1;
	private JTextField txtb1;

	public TextBox_page() {
		// TODO Auto-generated constructor stub
		
		btn1 = new JButton("Submit Me");
		btn1.addActionListener(e -> wassup());
		txtb1 = new JTextField();
		txtb1.setPreferredSize(new Dimension(250,30));
		
		this.setTitle("Hackerman System");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.add(btn1);
		this.add(txtb1);
		this.pack();
		this.setVisible(true);
	}

	private Object wassup() {
		// TODO Auto-generated method stub
		System.out.println(txtb1.getText());
		txtb1.setText("");
		String name = "francis";
		return null;
	}
}
