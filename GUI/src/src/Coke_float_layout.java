package src;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Coke_float_layout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a = 0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JLabel label1;
	
	public Coke_float_layout() {
		// TODO Auto-generated constructor stub
		
		label1 = new JLabel();
		label1.setText("Welcome To Coke Float!");
		//label1.setBounds(170,150,250,50);
		
		button1 = new JButton();
		button1.setText("Press me");
		//button1.setBounds(170,200,120,50);
		button1.addActionListener(e -> bro());
		
		button2 = new JButton();
		button2.setText("Open Hackerman page2");
		button2.addActionListener(e -> new_window());
		
		button3 = new JButton();
		button3.setText("Open Hackerman page3");
		button3.addActionListener(e -> new_window2());
		
		button4 = new JButton();
		button4.setText("Open Hackerman page4");
		button4.addActionListener(e -> new_window3());
		
		
		this.setTitle("Coke Float Layout");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		//this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setLayout(new GridLayout(4,3));
		this.add(label1);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(new JButton("3"));
		this.add(new JButton("4"));
		this.add(new JButton("5"));
		this.add(new JButton("6"));
		this.add(new JButton("7"));
		this.add(new JButton("8"));
		this.add(new JButton("9"));
		this.setVisible(true);
	}
	
	private void new_window() {
		//My_frame page1 = new My_frame();
		//JOptionPane.showMessageDialog(null, "wassup bro? ","what is the title again?",JOptionPane.PLAIN_MESSAGE);
		//String name = JOptionPane.showInputDialog("What is your name?");
		//System.out.println("your name: "+name);
		new TextBox_page();
	}
	
	
	private void new_window2() {
		new Tool_bar();
	}
	
	private void new_window3() {
		new Login();
	}

	private void bro() {
		// TODO Auto-generated method stub
		label1.setText("Very nice Coke Float eh?");
		a++;
		System.out.println("Click count: "+a);
	}
}
