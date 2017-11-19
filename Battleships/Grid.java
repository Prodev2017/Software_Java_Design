package Battleships;

/*
 * Author: Michael Okarimia
 * Created: 10 November 2004 15:43:46
 * Modified: 10 November 2004 15:43:46
 * This program creates a grid that a game of 
 * Battleships can be played on
 * Improvements from code1 are:
 * 1: Destroyer ship now added
 * 2: Horizontal and vertical positioning is determined by int not char
 * 3: Grid is now Serializable
 */

import java.io.Serializable;

import Battleships.Ships.*;
import Battleships.exception.PositionExceedsBoardException;
import Battleships.exception.PositionOccupiedException;

@SuppressWarnings("serial")
public class Grid implements Serializable {
	private int[][] board;// two dimensional array to hold the board data

	private int userRow;
	private int userColumn;

	private boolean minePlaced = false;
	private boolean subPlaced = false;
	private boolean destPlaced = false;
	private boolean battlePlaced = false;
	private boolean airPlaced = false;

	private Minesweeper minesweeper;
	private Submarine submarine;
	private Destroyer destroyer;
	private Battleship battleship;
	private AircraftCarrier aircraftCarrier;

	/**
	 * Constructs a two dimensional array which represent the game board. All
	 * elements in the two dimensional array on the grid are set to (zero) 0,
	 * which represents an empty grid The board's dimensions are determined by
	 * the parameters i and j
	 * 
	 * @param i
	 *            the number of rows of the grid
	 * @param j
	 *            the number of columns of the grid
	 */
	public Grid(int i, int j) {
		userRow = i;
		userColumn = j;

		board = new int[userRow][userColumn];

		for (int a = 0; i < userRow; i++)
			for (int b = 0; j < userColumn; j++)
				board[a][b] = 0;
	}

	/**
	 * Returns the number of columns in the grid
	 */
	public int getWidth() {
		return userColumn;
	}

	/**
	 * Returns the number of rows in the grid
	 */

	public int getLength() {
		return userRow;
	}

	/**
	 * Checks the grid references and returns a boolean value if there is a ship
	 * on that spot
	 * 
	 * @param i
	 *            the column of the grid reference
	 * @param j
	 *            the row of the grid reference
	 * @return a boolean value, true if the grid contains a ship and false if it
	 *         contains either a miss or empty
	 */
	public boolean isValidPlaceForAShip(int i, int j) {
		int index;
		index = this.getGridVal(i, j);

		if (index > 1 && index < 8)
			return true;

		else
			return false;

	}

	/**
	 * Checks if all ships are sunk
	 */

	public boolean allShipsSunk() {
		return checkAirSunk() && checkBattleSunk() && checkDestSunk()
				&& checkSubSunk() && checkMineSunk();
	}

	public boolean checkMineSunk() {

		return minesweeper.isSunk();
	}

	public boolean checkSubSunk() {
		return submarine.isSunk();
	}

	public boolean checkDestSunk() {

		return destroyer.isSunk();
	}

	public boolean checkBattleSunk() {

		return battleship.isSunk();
	}

	public boolean checkAirSunk() {
		return aircraftCarrier.isSunk();
	}

	/**
	 * Checks if the minesweeper has been placed
	 */

	public boolean checkMinePlaced() {
		return minePlaced;
	}

	/**
	 * Sets minePlaced flag to true
	 */

	public void setMinePlacedTrue() {
		minePlaced = true;
	}

	public boolean addMine(int i, int j, int s) {
		boolean isHorizontal = (s == 0);

		try {
			minesweeper = new Minesweeper(this, i, j, isHorizontal);
		}

		catch (PositionOccupiedException Exception) {
			System.out
					.println(String
							.format("Cannot place %s Minesweeper here, position is occupied \n",
									(isHorizontal ? "horizontal" : "vertical")));
		}

		catch (PositionExceedsBoardException Exception) {
			System.out
					.println(String
							.format("Cannot place %s Minesweeper here, ship will not fit on grid \n",
									(isHorizontal ? "horizontal" : "vertical")));
		}

		return checkMinePlaced();
	}

	/**
	 * Checks if the Sub has been placed
	 */

	public boolean checkSubPlaced() {
		return subPlaced;
	}

	/**
	 * Sets subPlaced flag to true
	 */

	public void setSubPlacedTrue() {
		subPlaced = true;
	}

	/**
	 * Adds an Air object to the grid
	 */

	public boolean addAir(int i, int j, int s) {
		boolean isHorizontal = (s == 0);

		try {
			aircraftCarrier = new AircraftCarrier(this, i, j, isHorizontal);
		}

		catch (PositionOccupiedException Exception) {
			System.out
					.println(String
							.format("Cannot place %s Aircraft Carrier here, position is occupied \n",
									(isHorizontal ? "horizontal" : "vertical")));
		}

		catch (PositionExceedsBoardException Exception) {
			System.out
					.println(String
							.format("Cannot place %s Aircraft Carrier here, ship will not fit on grid \n",
									(isHorizontal ? "horizontal" : "vertical")));
		}

		return checkAirPlaced();

	}

	/**
	 * Adds a Submarine object to the grid
	 */

	public boolean addSub(int i, int j, int s) {
		boolean isHorizontal = (s == 0);

		try {

			Submarine sub = new Submarine(this, i, j, isHorizontal);
			submarine = sub;
		}

		catch (PositionOccupiedException Exception) {
			System.out.println(String.format(
					"Cannot place %s submarine here, position is occupied \n",
					(isHorizontal ? "horizontal" : "vertical")));
		}

		catch (PositionExceedsBoardException Exception) {
			System.out
					.println(String
							.format("Cannot place %s submarine here, ship will not fit on grid \n",
									(isHorizontal ? "horizontal" : "vertical")));
		}

		return checkSubPlaced();
	}

	/**
	 * Checks if the Destroyer has been placed
	 */

	public boolean checkDestPlaced() {
		if (destPlaced == true)
			return true;

		else
			return false;
	}

	/**
	 * Sets destPlaced flag to true
	 */

	public void setDestPlacedTrue() {
		destPlaced = true;
	}

	/**
	 * Adds a Destroyer object to the grid
	 */

	public boolean addDest(int i, int j, int s) {
		boolean isHorizontal = (s == 0);

		try {
			destroyer = new Destroyer(this, i, j, isHorizontal);
		}

		catch (PositionOccupiedException Exception) {
			System.out.println(String.format(
					"Cannot place %s destroyer here, position is occupied \n",
					(isHorizontal ? "horizontal" : "vertical")));
		}

		catch (PositionExceedsBoardException Exception) {
			System.out
					.println(String
							.format("Cannot place %s destroyer here, ship will not fit on grid \n",
									(isHorizontal ? "horizontal" : "vertical")));
		}

		return checkDestPlaced();
	}

	/**
	 * Checks if the Battleship has been placed
	 */
	public boolean checkBattlePlaced() {
		return battlePlaced;
	}

	/**
	 * Sets battlePlaced flag to true
	 */

	public void setBattlePlacedTrue() {
		battlePlaced = true;
	}

	/**
	 * Adds a Battle object to the grid
	 */

	public boolean addBattle(int i, int j, int s) {
		boolean isHorizontal = (s == 0);

		try {
			battleship = new Battleship(this, i, j, isHorizontal);
		}

		catch (PositionOccupiedException Exception) {
			System.out.println(String.format(
					"Cannot place %s battleship here, position is occupied \n",
					(isHorizontal ? "horizontal" : "vertical")));
		}

		catch (PositionExceedsBoardException Exception) {
			System.out
					.println(String
							.format("Cannot place %s battleship here, ship will not fit on grid \n",
									(isHorizontal ? "horizontal" : "vertical")));
		}
		return checkBattlePlaced();
	}

	/**
	 * Checks if the aircraftCarrier has been placed
	 */
	public boolean checkAirPlaced() {
		return isAirPlaced();
	}

	/**
	 * Sets airPlaced flag to true
	 */

	public void setAirPlacedTrue() {
		setAirPlaced(true);
	}

	/** Checks if all ships have been placed */
	public boolean allShipsPlaced() {
		return checkMinePlaced() && checkSubPlaced() && checkDestPlaced()
				&& checkBattlePlaced() && checkAirPlaced();
	}

	/**
	 * This method is used by the ship classes to add the ships to the grid.
	 * Sets the value of a grid location to a specified integer. The grid
	 * location must be set to (zero) 0.
	 * 
	 * @param i
	 *            the row index
	 * @param j
	 *            the column index
	 * @param value
	 *            the value of the square
	 */
	public void set(int i, int j, int value) {
		if (i > userRow || j > userColumn)
			throw new IllegalArgumentException(
					"Number is bigger that the grid size");
		if (i < 0 || j < 0 || value < 0)
			throw new IllegalArgumentException("Number cannot be negative");
		if (board[i][j] != 0)
			throw new IllegalArgumentException("Initial Position occupied");
		if (value == 0)
			throw new IllegalArgumentException("Number cannot = 0");
		board[i][j] = value;
	}

	/**
	 * This method is used by the shot() method to update the grid. Sets the
	 * value of a grid location to a specified integer. The grid location must
	 * be set to (zero) 0.
	 * 
	 * @param i
	 *            the row index
	 * @param j
	 *            the column index
	 * @param value
	 *            the value of the square
	 */
	public void update(int i, int j, int value) {
		if (i > userRow || j > userColumn)
			throw new IllegalArgumentException(
					"Number is bigger that the grid size");
		if (i < 0 || j < 0)
			throw new IllegalArgumentException("Number cannot be negative");
		if (value == 0)
			throw new IllegalArgumentException("Number cannot = 0");
		board[i][j] = value;
	}

	/**
	 * Returns the value of the given grid index
	 * 
	 * @param i
	 *            the row index
	 * @param j
	 *            the column index
	 */
	public int getGridVal(int i, int j) {
		if (i < 0 || j < 0)
			throw new IllegalArgumentException("Number cannot be negative");
		if (i > userRow || j > userColumn)
			throw new IllegalArgumentException(
					"Number is bigger that the grid size");
		return board[i][j];
	}

	/**
	 * Fires a shot on the grid
	 */
	public boolean shot(int i, int j) {
		int sqr = this.getGridVal(i, j);

		boolean hit = false;

		switch (sqr) {
		case 0:
			hit = false;
			this.update(i, j, 1);
			break;
		case 1:
			hit = false;
			break;

		case 2:
			minesweeper.scoreHit();
			this.update(i, j, (sqr - 8));
			hit = true;
			break;

		case 3:
			submarine.scoreHit();
			this.update(i, j, (sqr - 8));
			hit = true;
			break;

		case 4:
			battleship.scoreHit();
			this.update(i, j, (sqr - 8));
			hit = true;
			break;

		case 5:
			aircraftCarrier.scoreHit();
			this.update(i, j, (sqr - 8));
			hit = true;
			break;

		case 7:
			destroyer.scoreHit();
			this.update(i, j, (sqr - 8));
			hit = true;
			break;

		default:
			break;
		}

		return hit;

	}

	/**
	 * Creates a string representation of the game board like so: |000| |050|
	 * |000|
	 * 
	 * @return the string representation
	 */

	public String toString() {
		String r = "";
		for (int i = 0; i < userRow; i++) // change these to ROWS to use the
											// default
		{

			r = r + "|";
			for (int j = 0; j < userColumn; j++)
				// change this to CoLumns for default
				r = r + board[i][j];
			r = r + "|\n";
		}
		return r;
	}

	public void setAirPlaced(boolean airPlaced) {
		this.airPlaced = airPlaced;
	}

	public boolean isAirPlaced() {
		return airPlaced;
	}

	public boolean checkIsShipPlaced(Ship ship) {
		Class<? extends Ship> shipclass = ship.getClass();
		if (shipclass.equals(AircraftCarrier.class))
			return airPlaced;
		if (shipclass.equals(Battleship.class))
			return battlePlaced;
		if (shipclass.equals(Destroyer.class))
			return destPlaced;
		if (shipclass.equals(Submarine.class))
			return subPlaced;
		if (shipclass.equals(Minesweeper.class))
			return minePlaced;
		return false;
	}

	public void setShipAsPlaced(Ship ship) {
		Class<? extends Ship> shipClass = ship.getClass();
		if (shipClass.equals(AircraftCarrier.class)) {
			airPlaced = true;
		}
		if (shipClass.equals(Battleship.class)) {
			battlePlaced = true;
		}
		if (shipClass.equals(Destroyer.class)) {
			destPlaced = true;
		}
		if (shipClass.equals(Submarine.class)) {
			subPlaced = true;
		}
		if (shipClass.equals(Minesweeper.class)) {
			minePlaced = true;
		}

	}

}
