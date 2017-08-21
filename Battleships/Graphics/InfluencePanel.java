package Battleships.Graphics;

/*
 * Author: Michael
 * Created: 16 April 2005 17:25:31
 * Modified: 16 April 2005 17:25:31
 */

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class InfluencePanel extends JPanel {

	public void paintHit(Graphics g) {
		super.paintComponent(g);

		InfluenceMapGraphic.paint(g, 100, 100, 170);

	}

	public void paintComponent(Graphics g) {
		this.setSize(200, 200);

		// setBackground(Color.white);
		super.paintComponent(g);
		// ship objects hold their starting co-ord and orientation
		DrawGrid.paint(g, 0, 0);

	}

}
