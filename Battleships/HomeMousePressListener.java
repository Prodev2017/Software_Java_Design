package Battleships;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Battleships.Graphics.HomePanel;

public class HomeMousePressListener extends MouseAdapter {

	@SuppressWarnings("unused")
	private HomePanel a;
	private GUI gui;

	public HomeMousePressListener(HomePanel p, GUI gui2) {
		a = p;
		gui = gui2;
	}

	public void mousePressed(MouseEvent event) {

		int x = event.getX();
		int y = event.getY();

		int gridj = resolveAxisCoOrdinate(x);
		int gridi = resolveAxisCoOrdinate(y);

		if (!gui.data.gameState.isBothPlayerAndAgentShipsDeployed()) {
			gui.deploy(gridi, gridj);

		}
		System.out.println("Element corresponds to " + gridi + gridj);
	}

	private int resolveAxisCoOrdinate(int x) {
		if (x < 20)
			return 0;
		else if (x < 40)
			return 1;
		else if (x < 60)
			return 2;
		else if (x < 80)
			return 3;
		else if (x < 100)
			return 4;
		else if (x < 120)
			return 5;
		else if (x < 140)
			return 6;
		else if (x < 160)
			return 7;
		else if (x < 180)
			return 8;
		else if (x < 200)
			return 9;
		return -1;
	}

}
