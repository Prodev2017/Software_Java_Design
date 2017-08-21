package Battleships.patterns;

public abstract class BattleshipEngineTemplate {
	public final void start() {
		init();
		deployShips();
		setPlayerTurn();
		playGame();
		gameOver();
	}

	public abstract void init();
	public abstract void deployShips();
	public abstract void setPlayerTurn();
	public abstract void playGame();
	public abstract void gameOver();
}
