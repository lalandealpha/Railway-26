package layoutTest;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {
	public BorderLayoutTest() {
		this.setTitle("Vi Du");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		
		BorderLayout borderLayout = new BorderLayout();
		BorderLayout borderLayout2 = new BorderLayout(15, 15);
		this.setLayout(borderLayout2);
		
		JButton button1 = new JButton("1"); 
		JButton button2 = new JButton("2"); 
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		
		this.add(button1, BorderLayout.NORTH);
		this.add(button2, BorderLayout.SOUTH);
		this.add(button3, BorderLayout.EAST);
		this.add(button4, BorderLayout.WEST);
		this.add(button5, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutTest();
	}
}
