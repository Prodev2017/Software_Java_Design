package Battleships.exception;

/*
 * Author: Michael
 * Created: 11 November 2004 19:53:55
 * Modified: 11 November 2004 19:53:55
 */

@SuppressWarnings("serial")
public class PositionExceedsBoardException extends RuntimeException {
	public PositionExceedsBoardException() {
	}

	PositionExceedsBoardException(String reason) {
		super(reason);
	}

}
