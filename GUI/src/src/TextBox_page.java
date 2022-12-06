package src;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TextBox_page extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn1;
	private JTextField txtb1;
	private JCheckBox checkbox;
	private JRadioButton rad_windows;
	private JRadioButton rad_linux;
	private JRadioButton rad_apple;
	@SuppressWarnings("rawtypes")
	private JComboBox combobox1;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TextBox_page() {
		// TODO Auto-generated constructor stub
		
		btn1 = new JButton("Submit Me");
		btn1.addActionListener(e -> wassup());
		
		txtb1 = new JTextField();
		txtb1.setPreferredSize(new Dimension(250,30));
		
		checkbox = new JCheckBox();
		checkbox.setText("are you a robot?");
		
		String[] pets = {"dog","cat","bird","fish","spider"};
		combobox1 = new JComboBox(pets);
		combobox1.addActionListener(e -> select_pet());
		
		rad_windows = new JRadioButton("Windows");
		rad_windows.addActionListener(e -> select_pc());
		rad_linux = new JRadioButton("Linux");
		rad_linux.addActionListener(e -> select_pc());
		rad_apple = new JRadioButton("Apple");
		rad_apple.addActionListener(e -> select_pc());
		
		ButtonGroup group = new ButtonGroup();
		group.add(rad_windows);
		group.add(rad_apple);
		group.add(rad_linux);
		
		this.setTitle("Hackerman System");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.add(btn1);
		this.add(checkbox);
		this.add(txtb1);
		this.add(rad_windows);
		this.add(rad_linux);
		this.add(rad_apple);
		this.add(combobox1);
		this.pack();
		this.setVisible(true);
	}

	private Object wassup() {
		// TODO Auto-generated method stub
		System.out.println(txtb1.getText()+"\n"+checkbox.isSelected());
		System.out.println();
		txtb1.setText("");
		return null;
	}
	
	private void select_pc() {
		if (rad_windows.isSelected()) {
			System.out.println("you have selected Windows");
		}
		else if (rad_apple.isSelected()) {
			System.out.println("you have selected Apple");
		}
		else if (rad_linux.isSelected()) {
			System.out.println("you have selected Linux");
		}
	}
	private void select_pet() {
		System.out.println(combobox1.getSelectedItem());
	}
}
