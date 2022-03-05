package layoutTest;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest extends JFrame {
	public FlowLayoutTest() {
		this.setTitle("Vi Du");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		
		FlowLayout flowLayout = new FlowLayout();
		FlowLayout flowLayout2 = new FlowLayout(FlowLayout.RIGHT);
		FlowLayout flowLayout3 = new FlowLayout(FlowLayout.CENTER, 50, 50);
		this.setLayout(flowLayout3);
		
		JButton button1 = new JButton("1"); 
		JButton button2 = new JButton("2"); 
		JButton button3 = new JButton("3");
		
		this.add(button1);
		this.add(button2);
		this.add(button3);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutTest();
	}
}
