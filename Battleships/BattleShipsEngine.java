package Battleships;

import javax.swing.JTextField;

import Battleships.Graphics.AttackPanel;
import Battleships.Graphics.HomePanel;
import Battleships.Graphics.InfluencePanel;
import Battleships.patterns.BattleshipEngineTemplate;

public class BattleShipsEngine extends BattleshipEngineTemplate {
	public AttackPanel attackPanel;
	public HomePanel homePanel;
	public InfluencePanel influenceMapPanel;
	public JTextField outText;
	public int i;
	public int j;
	public GameState gameState;
	public boolean agentWins;
	public boolean horiz;
	public boolean showMap;
	public boolean minePlaced;
	public boolean destPlaced;
	public boolean subPlaced;
	public boolean battlePlaced;

	public boolean agentMineSunk;
	public boolean agentDestSunk;
	public boolean agentSubSunk;
	public boolean agentAirSunk;
	public boolean playerMineSunk;
	public boolean paintMineSunk;
	public boolean paintDestSunk;
	public boolean paintSubSunk;
	public boolean paintBattleSunk;
	public boolean paintAirSunk;

	/*
	 * Dodadeno
	 */
	public GUI gui;
	public Agent smith;

	public BattleShipsEngine() {
	}

	@Override
	public void init() {
		gui = new GUI(new GameState());
		smith = new Agent();
	}
	
	@Override
	public void deployShips() {
		System.out.println("PlayerTurn " + gui.data.gameState.isPlayerTurn());
		System.out.println("Deployed "
				+ gui.data.gameState.isBothPlayerAndAgentShipsDeployed());

		System.out.println("PlayerTurn " + gui.data.gameState.isPlayerTurn());
		System.out.println("Deployed "
				+ gui.data.gameState.isBothPlayerAndAgentShipsDeployed());

		while (!gui.data.gameState.playerHomeGrid.allShipsPlaced()) {
			// PlayerDeploymentPhase, wait for player to place all their ships
		}

		gui.data.gameState.addAgentShips(smith.placeShips());
	}

	@Override
	public void setPlayerTurn() {
		gui.data.gameState.setPlayerTurn();
		gui.data.outText.setText(gui.data.gameState.turnToString());
	}

	@Override
	public void playGame() {
		while (!gui.getGameOver()) {

			while (gui.data.gameState.isPlayerTurn() && !gui.getGameOver()) {
				gui.data.gameState.setShipSunkStates();
				if (gui.data.gameState.areAllAgentShipsSunk()) {
					System.out.println("All sunk");
					gui.data.gameState.SetGameOver();
					gui.data.gameState.PlayerIsTheWinner();
				}
			}
			gui.repaint();

			while (gui.data.gameState.isAgentTurn()
					&& !gui.data.gameState.IsGameOver()) {

				System.out.println("agent turn");
				smith.nextShot(gui.data.gameState.influenceMap,
						gui.data.gameState.compAtt);
				gui.agentShot(smith.getI(), smith.getJ());
				System.out.println("shot at " + smith.getI() + " "
						+ smith.getJ());
				System.out.println(gui.data.gameState.compAtt.toString());
				// if(gameState.playerHome.get(i,j

				determineIfShotSunkAShip();

				gui.data.gameState.setShipSunkStates();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (gui.data.gameState.getPlayerShipsSunk()) {
					gui.setAgentWins();
					gui.data.gameState.SetGameOver();
					gui.data.gameState.setPlayerTurn();

				}
			}

		}

	}
	
	@Override
	public void gameOver() {
		System.out.println("Game Over!");
		if (gui.data.gameState.isPlayerWinner()) {
			System.out.println("Player Wins");
			gui.setOut("Game Over! You Win!");
		} else {
			System.out.println("Computer Wins");
			gui.setOut("Game Over! Agent Wins!");
		}
	}

	private void determineIfShotSunkAShip() {
		System.out.println("Player Home board \n"
				+ gui.data.gameState.playerHomeGrid.toString());
		isMineSunk();
		isDestSunk();
		isSubSunk();
		isBattleSunk();
		isAirSunk();
	}

	private void isMineSunk() {
		if (gui.data.gameState.playerHomeGrid.checkMineSunk()
				&& !gui.getPaintMineSunk()) {
			for (int i = 0; i < 10; i++) // change these to ROWS to use the
											// default
			{
				for (int j = 0; j < 10; j++)// change this to CoLumns for
											// default
				{
					if (gui.data.gameState.playerHomeGrid.getGridVal(i, j) == -6) {
						smith.setSunk(i, j);
						gui.setPaintMineSunk();
					}
				}
			}
		}
	}

	private void isDestSunk() {
		if (gui.data.gameState.playerHomeGrid.checkDestSunk()
				&& !gui.getPaintDestSunk()) {
			for (int i = 0; i < 10; i++) // change these to ROWS to use the
											// default
			{
				for (int j = 0; j < 10; j++)// change this to CoLumns for
											// default
				{
					if (gui.data.gameState.playerHomeGrid.getGridVal(i, j) == -1) {
						smith.setSunk(i, j);
						gui.setPaintDestSunk();
					}
				}
			}
		}
	}

	private void isSubSunk() {
		if (gui.data.gameState.playerHomeGrid.checkSubSunk()
				&& !gui.getPaintSubSunk()) {
			for (int i = 0; i < 10; i++) // change these to ROWS to use the
											// default
			{
				for (int j = 0; j < 10; j++)// change this to CoLumns for
											// default
				{
					if (gui.data.gameState.playerHomeGrid.getGridVal(i, j) == -5) {
						smith.setSunk(i, j);
						gui.setPaintSubSunk();
					}
				}
			}
		}
	}

	private void isBattleSunk() {
		if (gui.data.gameState.playerHomeGrid.checkBattleSunk()
				&& !gui.getPaintBattleSunk()) {
			for (int i = 0; i < 10; i++) // change these to ROWS to use the
											// default
			{
				for (int j = 0; j < 10; j++)// change this to CoLumns for
											// default
				{
					if (gui.data.gameState.playerHomeGrid.getGridVal(i, j) == -4) {
						smith.setSunk(i, j);
						gui.setPaintBattleSunk();
					}
				}
			}
		}
	}

	private void isAirSunk() {
		if (gui.data.gameState.playerHomeGrid.checkAirSunk()
				&& !gui.getPaintAirSunk()) {
			for (int i = 0; i < 10; i++) // change these to ROWS to use the
											// default
			{
				for (int j = 0; j < 10; j++)// change this to CoLumns for
											// default
				{
					if (gui.data.gameState.playerHomeGrid.getGridVal(i, j) == -3) {
						smith.setSunk(i, j);
						gui.setPaintAirSunk();
					}
				}
			}
		}
	}
}