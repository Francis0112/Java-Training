package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class My_frame extends JFrame {

	/**
	 * 
	 */
	private JButton button1;
	private JLabel label1;
	private int a = 0;
	
	private static final long serialVersionUID = 1L;

	public My_frame() {
		// TODO Auto-generated constructor stub
		
		label1 = new JLabel();
		label1.setText("Result:");
		label1.setBounds(190,150,250,100);
		
		button1 = new JButton();
		button1.setText("Press me");
		button1.setBounds(180, 210, 100, 50);
		button1.addActionListener(e -> presser());
		
		this.setTitle("Hello world System.");
		this.setDefaultCloseOperation(My_frame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500,500); 
		this.setLayout(null);
		this.setResizable(false);
		this.add(label1);
		this.add(button1);
		//this.pack();
	}
	
	void presser() {
		a++;
		label1.setText("Click Count: "+a);
		System.out.println("click count: "+a);
	}
	
}
