package fontTest.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;

import fontTest.controller.LastButtonController;
import fontTest.model.LastButtonModel;

@SuppressWarnings("serial")
public class LastButtonView extends JFrame {
	private LastButtonModel lastButtonModel;
	private JLabel jLabel;
	private JButton jButtonOne;
	private JButton jButtonTwo;
	private JButton jButtonThree;
	private JButton jButtonFour;
	
	public LastButtonView() {
		lastButtonModel = new LastButtonModel();
		init();
	}  
	
	public void init() {
		this.setTitle("Last Button");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		LastButtonController controller = new LastButtonController(this);
		
		Font font = new Font("Arial", Font.BOLD, 40);
		jButtonOne = new JButton("1");
		jButtonOne.setFont(font);
		jButtonOne.addActionListener(controller);
		jButtonTwo = new JButton("2");
		jButtonTwo.setFont(font);
		jButtonTwo.addActionListener(controller);
		jButtonThree = new JButton("3");
		jButtonThree.setFont(font);
		jButtonThree.addActionListener(controller);
		jButtonFour = new JButton("4");
		jButtonFour.setFont(font);
		jButtonFour.addActionListener(controller);
		
		Font font2 = new Font("Arial", Font.BOLD, 15);
		jLabel = new JLabel("---------", JButton.CENTER);
		jLabel.setFont(font2);
		
		JPanel jPanelNumbers = new JPanel();
		jPanelNumbers.setLayout(new GridLayout(2, 2));
		jPanelNumbers.add(jButtonOne);
		jPanelNumbers.add(jButtonTwo);
		jPanelNumbers.add(jButtonThree);
		jPanelNumbers.add(jButtonFour);
		
		JPanel jPanelLabel = new JPanel();
		jPanelLabel.setLayout(new BorderLayout());
		jPanelLabel.add(jLabel, BorderLayout.CENTER);
		
		this.setLayout(new BorderLayout());
		this.add(jPanelNumbers, BorderLayout.CENTER);
		this.add(jPanelLabel, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void push(JButton jButton) {
		jLabel.setText("Last button pushed was no. " + setAndGetLastButton(Integer.parseInt(jButton.getActionCommand())));
	}
	
	public int setAndGetLastButton(int value) {
		lastButtonModel.setValue(value);
		return lastButtonModel.getValue();
	}

	/**
	 * @return the jButtonOne
	 */
	public JButton getjButtonOne() {
		return jButtonOne;
	}

	/**
	 * @return the jButtonTwo
	 */
	public JButton getjButtonTwo() {
		return jButtonTwo;
	}

	/**
	 * @return the jButtonThree
	 */
	public JButton getjButtonThree() {
		return jButtonThree;
	}

	/**
	 * @return the jButtonFour
	 */
	public JButton getjButtonFour() {
		return jButtonFour;
	}
	
	
}
