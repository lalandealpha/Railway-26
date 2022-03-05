package fontTest.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fontTest.view.LastButtonView;

public class LastButtonController implements ActionListener {
	private LastButtonView lastButtonView;

	public LastButtonController(LastButtonView lastButtonView) {
		this.lastButtonView = lastButtonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("1")) {
			lastButtonView.push(lastButtonView.getjButtonOne());
		} else if (e.getActionCommand().equals("2")) {
			lastButtonView.push(lastButtonView.getjButtonTwo());
		} else if (e.getActionCommand().equals("3")) {
			lastButtonView.push(lastButtonView.getjButtonThree());
		} else if (e.getActionCommand().equals("4")) {
			lastButtonView.push(lastButtonView.getjButtonFour());
		}	
	} 
}
