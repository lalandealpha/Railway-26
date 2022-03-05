//
package calculatorTest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class MyCalculator extends JFrame {
	
	public MyCalculator() {
		this.setTitle("My Calculator");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		
		JTextField jTextField = new JTextField(50);
		JPanel jPanelHead = new JPanel();
		jPanelHead.setLayout(new BorderLayout());
		jPanelHead.add(jTextField, BorderLayout.CENTER);
		
		JButton jButton0 = new JButton("0");
		JButton jButton1 = new JButton("1");
		JButton jButton2 = new JButton("2");
		JButton jButton3 = new JButton("3");
		JButton jButton4 = new JButton("4");
		JButton jButton5 = new JButton("5");
		JButton jButton6 = new JButton("6");
		JButton jButton7 = new JButton("7");
		JButton jButton8 = new JButton("8");
		JButton jButton9 = new JButton("9");
		JButton jButtonCong = new JButton("+");
		JButton jButtonTru = new JButton("-");
		JButton jButtonNhan = new JButton("*");
		JButton jButtonChia = new JButton("/");
		JButton jButtonBang = new JButton("=");
		
		JPanel jPanelButtons = new JPanel();
		jPanelButtons.setLayout(new GridLayout(5, 3));
		jPanelButtons.add(jButton0);
		jPanelButtons.add(jButton1);
		jPanelButtons.add(jButton2);
		jPanelButtons.add(jButton3);
		jPanelButtons.add(jButton4);
		jPanelButtons.add(jButton5);
		jPanelButtons.add(jButton6);
		jPanelButtons.add(jButton7);
		jPanelButtons.add(jButton8);
		jPanelButtons.add(jButton9);
		jPanelButtons.add(jButtonCong);
		jPanelButtons.add(jButtonTru);
		jPanelButtons.add(jButtonNhan);
		jPanelButtons.add(jButtonChia);
		jPanelButtons.add(jButtonBang);
		
		this.setLayout(new BorderLayout());
		this.add(jPanelHead, BorderLayout.NORTH);
		this.add(jPanelButtons, BorderLayout.CENTER);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MyCalculator();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
