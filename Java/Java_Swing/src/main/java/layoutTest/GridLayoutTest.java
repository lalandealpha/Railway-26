package layoutTest;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest extends JFrame {
	public GridLayoutTest() {
		this.setTitle("Vi Du");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		
		GridLayout gridLayout = new GridLayout();
		GridLayout gridLayout2 = new GridLayout(4, 4);
		GridLayout gridLayout3 = new GridLayout(4, 4, 25, 25);
		this.setLayout(gridLayout3);
		
		for (int i = 0; i < 16; i++) {
			JButton button = new JButton(i+ ""); 
			this.add(button);
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutTest();
	}
}
