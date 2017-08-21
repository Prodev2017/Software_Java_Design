package Battleships;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewButtonAction extends MouseAdapter {

	private GUI gui;

	public NewButtonAction(GUI gui2) {

		gui = gui2;
	}

	public void mousePressed(MouseEvent event) {
		gui.reset();
	}

}
