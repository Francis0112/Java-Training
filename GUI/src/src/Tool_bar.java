package src;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

public class Tool_bar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSlider slider1;
	private JLabel label1;
	public JProgressBar jbar;
	
	private void temp() {
		label1.setText("°C: "+slider1.getValue()+"%");
		System.out.println("°C: "+slider1.getValue()+"%");
	}
	
	
	private void wasup_bro() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int counter = 0;
				while (counter<=100) {
					jbar.setValue(counter);
					System.out.println("loading: "+jbar.getValue()+" %");
					try {
						Thread.sleep(200);
					} catch (Exception e) {
						// TODO: handle exception
					}
					counter+=1;
				}	
			}
		});
		thread.start();
	}
	
	

	public Tool_bar() {
		// TODO Auto-generated constructor stub
		
		label1 = new JLabel();
		label1.setText("°C: ");
		label1.setFont(new Font("Times", Font.BOLD, 25));
		
		slider1 = new JSlider(0,100,50);
		slider1.setPreferredSize(new Dimension(400,100));
		slider1.setPaintTicks(true);
		slider1.setMinorTickSpacing(5);
		slider1.setPaintTrack(true);
		slider1.setMajorTickSpacing(10);
		slider1.setPaintLabels(true);
		slider1.addChangeListener(e -> temp());
		
		jbar = new JProgressBar();
		jbar.setValue(0);
		jbar.setStringPainted(true);

		this.setTitle("Hackerman page 3");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(1000,200);
		this.add(label1);
		this.add(slider1);
		this.add(jbar);
		this.setVisible(true);
		wasup_bro();
	}
}
