package mvcTest.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import mvcTest.controller.CounterController;
import mvcTest.model.CounterModel;

public class CounterView extends JFrame {
	private CounterModel counterModel;
	JLabel jLabel;
	JButton jButtonUp;
	JButton jButtonDown;
	JButton jButtonReset;
	
	public CounterView() {
		counterModel = new CounterModel();
		init();
	}
	
	public void init() {
		this.setTitle("Counter");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		CounterController controller = new CounterController(this);
	
		jButtonUp = new JButton("UP");
		jButtonUp.addActionListener(controller);
		jButtonDown = new JButton("DOWN");
		jButtonDown.addActionListener(controller);
		jButtonReset = new JButton("RESET");
		jButtonReset.addActionListener(controller);
		
		jLabel = new JLabel(counterModel.getValue()+ "", JButton.CENTER);
		
		this.setLayout(new BorderLayout());
		this.add(jButtonUp, BorderLayout.WEST);
		this.add(jButtonDown, BorderLayout.EAST);
		this.add(jLabel, BorderLayout.CENTER);
		this.add(jButtonReset, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void increment() {
		counterModel.increment();
		jLabel.setText(counterModel.getValue()+"");
	}
	
	public void decrement() {
		counterModel.decrement();
		jLabel.setText(counterModel.getValue()+"");
	}
	
	public void reset() {
		counterModel.reset();
		jLabel.setText(counterModel.getValue()+"");
	}
}
