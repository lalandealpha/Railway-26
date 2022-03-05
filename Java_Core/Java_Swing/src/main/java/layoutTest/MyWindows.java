package layoutTest;

import javax.swing.JFrame;

public class MyWindows extends JFrame {
	public MyWindows() {
		
	}
	
	public void showOut() {
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyWindows().showOut();
		
	}
}
