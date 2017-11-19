package Battleships;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HideButtonAction extends MouseAdapter {

	private GUI gui;

	public HideButtonAction(GUI gui2) {

		gui = gui2;
	}

	public void mousePressed(MouseEvent event) {
		gui.hideMap();
	}

}
