package Battleships.Graphics;

/* File: Miss.java	
 Instructions to draw a splash, signifing a missed shot on the screen.
 */

import java.awt.*;

public class InfluenceMapGraphic {
	/**
	 * Constructs a splash shape with a given top left corner.
	 * 
	 * @param x
	 *            the x-coordinate of the top left corner
	 * @param y
	 *            the y-coordinate of the top left corner
	 */

	public static void paint(Graphics g, int xLeft, int yTop, int val) {

		setColor(g, val);

		g.fillRect(xLeft, yTop, 20, 20);

	}

	public static void setColor(Graphics g, int val) {
		if (val == 9) {
			g.setColor(Color.black);// set to black
			return;
		}

		if (val < 0) {
			g.setColor(Color.blue);
			return;
		}
		if (val == 0) {
			g.setColor(Color.white);
			return;
		}
		if (val == 1) {
			g.setColor(new Color(255, 200, 200));
			return;
		}
		if (val == 2) {
			g.setColor(new Color(255, 180, 180));
			return;
		}
		if (val == 3) {
			g.setColor(new Color(255, 160, 160));
			return;
		}
		if (val == 4) {
			g.setColor(new Color(255, 140, 140));
			return;
		}
		if (val == 5) {
			g.setColor(new Color(255, 120, 120));
			return;
		}
		if (val == 6) {
			g.setColor(new Color(255, 100, 100));
			return;
		}
		if (val == 7) {
			g.setColor(new Color(255, 80, 80));
			return;
		}
		if (val == 8) {
			g.setColor(new Color(255, 60, 60));
			return;
		}
		if (val == 10) {
			g.setColor(new Color(255, 40, 40));
			return;
		}
		if (val == 11) {
			g.setColor(new Color(255, 20, 20));
			return;
		}
		if (val == 12) {
			g.setColor(new Color(255, 0, 0));
			return;
		}
		if (val == 13) {
			g.setColor(new Color(255, 100, 0));
			return;
		}
		if (val == 14) {
			g.setColor(new Color(255, 120, 0));
			return;
		}
		if (val == 15) {
			g.setColor(new Color(255, 140, 0));
			return;
		}
		if (val == 16) {
			g.setColor(new Color(255, 160, 0));
			return;
		}
		if (val == 17) {
			g.setColor(new Color(255, 180, 0));
			return;
		}
		if (val == 18) {
			g.setColor(new Color(255, 200, 0));
			return;
		}
		if (val == 19) {
			g.setColor(new Color(255, 220, 0));
			return;
		}
		if (val == 20) {
			g.setColor(new Color(255, 240, 0));
			return;
		}
		if (val > 20) {
			g.setColor(new Color(255, 250, 0));
			return;
		}
	}
}