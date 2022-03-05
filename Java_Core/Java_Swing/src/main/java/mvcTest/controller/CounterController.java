package mvcTest.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvcTest.view.CounterView;

public class CounterController implements ActionListener {
	private CounterView counterView;

	public CounterController(CounterView counterView) {
		this.counterView = counterView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("UP")) {
			counterView.increment();
		} else if (e.getActionCommand().equals("DOWN")) { 
			counterView.decrement();
		} else if (e.getActionCommand().equals("RESET")) {
			counterView.reset();
		}
	} 
}
