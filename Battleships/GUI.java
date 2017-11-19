package Battleships;

import java.awt.*;

import javax.swing.*;

import Battleships.Graphics.*;

@SuppressWarnings("serial")
class GUI extends JFrame {

	BattleShipsEngine data = new BattleShipsEngine();

	public GUI(GameState paramGameState) {
		super("Battleships");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout(2, 1));
		this.setResizable(false);

		data.minePlaced = false;
		data.destPlaced = false;
		data.subPlaced = false;
		data.battlePlaced = false;

		setHoriz(true);
		data.showMap = true;

		data.paintMineSunk = false;
		data.paintDestSunk = false;
		data.paintSubSunk = false;
		data.paintBattleSunk = false;
		data.paintAirSunk = false;

		data.gameState = paramGameState;

		// attack panel
		Container APanel = new Container();
		APanel.setLayout(new GridLayout());

		// home panel
		Container HPanel = new Container();
		HPanel.setLayout(new GridLayout());

		// influence map
		Container IMPanel = new Container();
		IMPanel.setLayout(new GridLayout());

		// center panel where grids are
		Container CenterPanel = new Container();
		CenterPanel.setLayout(new GridLayout(1, 3));
		// create grids and maps

		// attack panel add listener
		data.attackPanel = new AttackPanel();
		data.attackPanel.addMouseListener(new AttackMousePressListener(
				data.attackPanel, this));

		data.homePanel = new HomePanel();
		data.homePanel.addMouseListener(new HomeMousePressListener(
				data.homePanel, this));

		data.influenceMapPanel = new InfluencePanel();

		APanel.add(data.attackPanel);
		CenterPanel.add(APanel);

		HPanel.add(data.homePanel);
		CenterPanel.add(HPanel);

		IMPanel.add(data.influenceMapPanel);
		CenterPanel.add(IMPanel);

		/*
		 * Creates the southPanel. This panel holds the ship status and rotate
		 * button
		 */
		Container southPanel = new Container();
		southPanel.setLayout(new GridLayout(1, 2));
		southPanel.setSize(400, 400);
		/*
		 * Creates the shipPanel which contains the status of ships
		 */

		Container shipPanel = new Container();
		shipPanel.setLayout(new GridLayout(4, 2));
		// adds the Ship Panel to the south panel
		southPanel.add(shipPanel);

		/*
		 * Creates the topShipPanel. This is where the placeholders for the top
		 * row of ships are
		 */

		Container topShipPanel = new Container();
		topShipPanel.setLayout(new FlowLayout());
		// add topShipPanel to shipPanel
		shipPanel.add(topShipPanel);

		/*
		 * Creates the topShipLabelPanel. This is where the labels for the top
		 * row of ships are
		 */

		Container topShipLabelPanel = new Container();
		topShipLabelPanel.setLayout(new FlowLayout());
		// add topShipPanel to shipPanel
		shipPanel.add(topShipLabelPanel);

		/*
		 * Creates the bottomShipPanel. This is where the placeholders for the
		 * top row of ships are
		 */

		Container bottomShipPanel = new Container();
		bottomShipPanel.setLayout(new FlowLayout());
		// add bottomShipPanel to shipPanel
		shipPanel.add(bottomShipPanel);

		/*
		 * Creates the bottomShipLabelPanel. This is where the labels for the
		 * bottom row of ships are
		 */

		Container bottomShipLabelPanel = new Container();
		bottomShipLabelPanel.setLayout(new FlowLayout());
		shipPanel.add(bottomShipLabelPanel);

		JButton NewButton = new JButton("New Game");
		topShipPanel.add(NewButton);
		// NewButton.addMouseListener(new NewButtonAction(this));

		JButton hideButton = new JButton("Hide Influence Map");
		topShipPanel.add(hideButton);
		hideButton.addMouseListener(new HideButtonAction(this));

		JButton destButton = new JButton("Rotate");
		topShipPanel.add(destButton);

		JButton rotateButton = new JButton("Rotate Ship");
		rotateButton.addMouseListener(new RotateButtonAction(this));
		bottomShipPanel.add(rotateButton);

		JButton quitButton = new JButton("Quit");
		quitButton.addMouseListener(new QuitButtonAction());
		bottomShipPanel.add(quitButton);

		/*
		 * Creates the container to go in the right hand side of the southPanel.
		 * This is where the rotate button will be.
		 */

		Container rotatePanel = new Container();
		rotatePanel.setLayout(new BorderLayout());
		// add rotatePanel to southPanel
		southPanel.add(rotatePanel);

		JButton viewMap = new JButton("View Influence Map");
		viewMap.addMouseListener(new ShowButtonAction(this));
		rotatePanel.add(viewMap, BorderLayout.NORTH);

		setOutText(new JTextField("lookat me!"));
		getOutText().setText(
				"Welcome To Battleships. Place ships on the middle grid");
		getOutText().setEditable(false);
		rotatePanel.add(getOutText());

		contentPane.add(CenterPanel, BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);

		this.pack();
		this.setSize(640, 400);
		this.setVisible(true);

	}

	public void setOut(String s) {
		getOutText().setText(s);
	}

	public void repaint() {
		Graphics attackPanelGraphics = data.attackPanel.getGraphics();

		for (int i = 0; i < 10; i++) // change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)// change this to CoLumns for default
			{
				if (data.gameState.playerAtt.getGridVal(i, j) == 1)
					MissIcon.paint(attackPanelGraphics, (j * 20), (i * 20));
				else if (data.gameState.isCompHomeGridLessThanMinus1(i, j))
					HitIcon.paint(attackPanelGraphics, (j * 20), (i * 20));

			}
		}

	}

	public boolean getPaintMineSunk() {
		return data.paintMineSunk;
	}

	public void setPaintMineSunk() {
		data.paintMineSunk = true;
	}

	public boolean getPaintDestSunk() {
		return data.paintDestSunk;
	}

	public void setPaintDestSunk() {
		data.paintDestSunk = true;
	}

	public boolean getPaintSubSunk() {
		return data.paintSubSunk;
	}

	public void setPaintSubSunk() {
		data.paintSubSunk = true;
	}

	public boolean getPaintBattleSunk() {
		return data.paintBattleSunk;
	}

	public void setPaintBattleSunk() {
		data.paintBattleSunk = true;
	}

	public boolean getPaintAirSunk() {
		return data.paintAirSunk;
	}

	public void setPaintAirSunk() {
		data.paintAirSunk = true;
	}

	public void reset() {
		data.i = 0;
		data.j = 0;

		data.gameState = new GameState();

		data.agentWins = false;

		setHoriz(false);
		data.showMap = false;

		data.minePlaced = false;
		data.destPlaced = false;
		data.subPlaced = false;
		data.battlePlaced = false;

		data.agentMineSunk = false;
		data.agentDestSunk = false;
		data.agentSubSunk = false;

		data.playerMineSunk = false;

		data.minePlaced = false;
		data.destPlaced = false;
		data.subPlaced = false;
		data.battlePlaced = false;
		setHoriz(true);
		data.showMap = true;
		this.pack();
		this.setSize(640, 400);
		this.setVisible(true);

	}

	public String placeAir(int i, int j) {
		String out = "";
		if (!this.data.gameState.playerHomeGrid.checkAirPlaced()) {
			if (isShipRotatedHorizonally()) {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addAir(i, j, 0);

				Graphics hp = data.homePanel.getGraphics();

				if (valid) {
					AircraftCarrier.paint(hp, (j * 20), (i * 20), 'h');
					out = out + data.gameState.playerHomeGrid.toString();
					data.gameState.playerHomeGrid.setAirPlaced(true);
					getOutText().setText("Air Placed");
				} else {
					getOutText().setText("Aircraft Carrier Will Not Fit Here");
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
				}
			}

			else {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addAir(i, j, 1);
				if (valid) {
					Graphics hp = data.homePanel.getGraphics();
					AircraftCarrier.paint(hp, (j * 20), (i * 20), 'v');
					out = out + data.gameState.playerHomeGrid.toString();
					data.gameState.playerHomeGrid.setAirPlacedTrue();
					getOutText().setText("Air Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
				}

			}
		}
		return out;
	}

	public String placeBattle(int i, int j) {
		String out = "";
		if (data.gameState.playerHomeGrid.isAirPlaced() && !data.battlePlaced) {
			if (isShipRotatedHorizonally()) {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addBattle(i, j, 0);

				Graphics hp = data.homePanel.getGraphics();

				if (valid) {
					Battleship.paint(hp, (j * 20), (i * 20), 'h');
					out = out + data.gameState.playerHomeGrid.toString();
					data.battlePlaced = true;
					// outText.setText("Battleship Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
					getOutText().setText("Battleships Will Not Fit Here");
				}
			}

			else {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addBattle(i, j, 1);
				if (valid) {
					Graphics hp = data.homePanel.getGraphics();
					Battleship.paint(hp, (j * 20), (i * 20), 'v');
					out = out + data.gameState.playerHomeGrid.toString();
					data.battlePlaced = true;
					getOutText().setText("Battleship Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
					getOutText().setText("Battleships Will Not Fit Here");
				}

			}
		}
		return out;
	}

	public String placeDest(int i, int j) {
		String out = "";
		if (data.gameState.playerHomeGrid.isAirPlaced() && data.battlePlaced
				&& !data.destPlaced) {
			if (isShipRotatedHorizonally()) {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addDest(i, j, 0);

				Graphics hp = data.homePanel.getGraphics();

				if (valid) {
					Destroyer.paint(hp, (j * 20), (i * 20), 'h');
					out = out + data.gameState.playerHomeGrid.toString();
					data.destPlaced = true;
					getOutText().setText("Destroyer Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
					getOutText().setText("Destroyer Will Not Fit Here");
				}
			}

			else {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addDest(i, j, 1);
				if (valid) {
					Graphics hp = data.homePanel.getGraphics();
					Destroyer.paint(hp, (j * 20), (i * 20), 'v');
					out = out + data.gameState.playerHomeGrid.toString();
					data.destPlaced = true;
					getOutText().setText("Destroyer Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();

				}

			}
		}
		return out;
	}

	public String placeSub(int i, int j) {
		String out = "";
		if (data.gameState.playerHomeGrid.isAirPlaced() && data.battlePlaced
				&& data.destPlaced && !data.subPlaced) {
			if (isShipRotatedHorizonally()) {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addSub(i, j, 0);

				Graphics hp = data.homePanel.getGraphics();

				if (valid) {
					Submarine.paint(hp, (j * 20), (i * 20), 'h');
					out = out + data.gameState.playerHomeGrid.toString();
					data.subPlaced = true;
					getOutText().setText("Submarine Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
					getOutText().setText("Submarine Will Not Fit Here");
				}
			}

			else {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addSub(i, j, 1);
				if (valid) {
					Graphics hp = data.homePanel.getGraphics();
					Submarine.paint(hp, (j * 20), (i * 20), 'v');
					out = out + data.gameState.playerHomeGrid.toString();
					data.subPlaced = true;
					getOutText().setText("Submarine Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
					getOutText().setText("Submarine Will Not Fit Here");
				}

			}
		}
		return out;
	}

	public String placeMine(int i, int j) {
		String out = "";
		if (data.gameState.playerHomeGrid.isAirPlaced() && data.battlePlaced
				&& data.destPlaced && data.subPlaced && !data.minePlaced) {
			if (isShipRotatedHorizonally()) {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addMine(i, j, 0);

				Graphics hp = data.homePanel.getGraphics();

				if (valid) {
					Minesweeper.paint(hp, (j * 20), (i * 20), 'h');
					out = out + data.gameState.playerHomeGrid.toString();
					data.minePlaced = true;
					getOutText().setText("Minesweeper Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
					getOutText().setText("Minesweeper Will Not Fit Here");
				}
			}

			else {
				boolean valid;
				valid = data.gameState.playerHomeGrid.addMine(i, j, 1);
				if (valid) {
					Graphics hp = data.homePanel.getGraphics();
					Minesweeper.paint(hp, (j * 20), (i * 20), 'v');
					out = out + data.gameState.playerHomeGrid.toString();
					data.minePlaced = true;
					getOutText().setText("Minesweeper Placed");
				} else {
					out = "not valid";
					out = out + data.gameState.playerHomeGrid.toString();
					getOutText().setText("Minesweeper Will Not Fit Here");
				}

			}

			if (data.gameState.playerHomeGrid.isAirPlaced()
					&& data.battlePlaced && data.destPlaced && data.subPlaced
					&& data.minePlaced)
				this.endDeploymentPhase();

		}

		return out;
	}

	public boolean rotate() {
		setHoriz(!isShipRotatedHorizonally());
		if (isShipRotatedHorizonally()
				&& !data.gameState.isBothPlayerAndAgentShipsDeployed())
			getOutText().setText("Ship Will Be Placed Horizontally");
		if (!isShipRotatedHorizonally()
				&& !data.gameState.isBothPlayerAndAgentShipsDeployed())
			getOutText().setText("Ship Will Be Placed Vertically");
		return isShipRotatedHorizonally();
	}

	public void showMap() {
		data.showMap = true;
		this.paintMap();
		getOutText().setText("Influence Map shown");
	}

	public void hideMap() {
		data.showMap = false;

		Graphics g = data.influenceMapPanel.getGraphics();

		for (int i = 0; i < 10; i++) // change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)// change this to CoLumns for default
			{
				int col = 0;
				InfluenceMapGraphic.paint(g, (j * 20), (i * 20), col);
			}
		}

		getOutText().setText("Influence Map Hidden");
	}

	public String deploy(int i, int j) {
		String out1 = "";

		out1 = this.placeAir(i, j);
		out1 = out1 + "\n" + this.placeBattle(i, j);
		out1 = out1 + "\n" + this.placeDest(i, j);
		out1 = out1 + "\n" + this.placeSub(i, j);
		out1 = out1 + "\n" + this.placeMine(i, j);
		out1 = out1 + data.gameState.playerTurn;
		return out1;
	}

	public void setAgentWins() {
		data.agentWins = true;

	}

	public boolean getGameOver() {
		return data.gameState.IsGameOver();
	}

	public void endDeploymentPhase() {
		if (data.minePlaced && data.destPlaced && data.subPlaced
				&& data.battlePlaced
				&& data.gameState.playerHomeGrid.isAirPlaced())
			data.gameState.SetAllShipsDeployed();
		getOutText()
				.setText(
						"All Ships Deployed, Player's Turn! Click on the left grid to fire shots");
		this.data.gameState.setPlayerTurn();
		data.outText.setText(data.gameState.turnToString());
	}

	public void paintMap() {

		Graphics g = data.influenceMapPanel.getGraphics();

		for (int i = 0; i < 10; i++) // change these to ROWS to use the default
		{
			for (int j = 0; j < 10; j++)// change this to CoLumns for default
			{
				int col = data.gameState.influenceMap.getVal(i, j);

				if (data.showMap) {
					InfluenceMapGraphic.paint(g, (j * 20), (i * 20), col);
				}
			}
		}

	}

	public void paintPlayerAttackGrid() {
		this.data.gameState.setShipSunkStates();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (data.gameState.isCompHomegridRefIsminus3(i, j)
						&& data.gameState.isAgentAirSunk()) {
					Graphics attackPanelGraphics = data.attackPanel
							.getGraphics();
					SunkIcon.paint(attackPanelGraphics, (j * 20), (i * 20));
				}

				if (data.gameState.isCompHomeGridRefMinus4(i, j)
						&& data.gameState.isAgentBattleSunk()) {
					Graphics ap = data.attackPanel.getGraphics();
					SunkIcon.paint(ap, (j * 20), (i * 20));
				}
			}
		}
	}

	public void agentShot(int X, int Y)

	{
		if (data.gameState.agentTurn
				&& data.gameState.isBothPlayerAndAgentShipsDeployed()) {
			int sqrVal = data.gameState.playerHomeGrid.getGridVal(X, Y);

			if (sqrVal < 0 || sqrVal == 1) {
				System.out.println("Shot already taken! Have another go");
			}

			if (sqrVal == 0) {
				System.out.println(data.gameState.playerHomeGrid.shot(X, Y));
				data.gameState.compAtt.update(X, Y, 1);
				data.gameState.influenceMap.miss(X, Y);
				this.paintMap();
				Graphics hp = data.homePanel.getGraphics();
				MissIcon.paint(hp, (Y * 20), (X * 20));
				getOutText().setText("Agent Has Missed. Player's Turn");
				this.data.gameState.setPlayerTurn();
				data.outText.setText(data.gameState.turnToString());
			}

			if (sqrVal > 1) {
				System.out.println(data.gameState.playerHomeGrid.shot(X, Y));
				data.gameState.compAtt.update(X, Y, 8);
				data.gameState.influenceMap.hit(X, Y);
				Graphics hp = data.homePanel.getGraphics();
				HitIcon.paint(hp, (Y * 20), (X * 20));
				getOutText().setText(
						"Agent Has Hit One Of your ships! Agent's Turn again");
				this.paintMap();

			}

			System.out.println("compAtt");
			System.out.println(data.gameState.compAtt.toString());

			if (sqrVal == 0)
				this.data.gameState.setPlayerTurn();

		}

		System.out
				.println("Map is \n" + data.gameState.influenceMap.toString());

	}

	private void setHoriz(boolean horiz) {
		this.data.horiz = horiz;
	}

	private boolean isShipRotatedHorizonally() {
		return data.horiz;
	}

	public void setOutText(JTextField outText) {
		this.data.outText = outText;
	}

	public JTextField getOutText() {
		return data.outText;
	}
}