package Battleships.exception;

/*
 * Author: Michael
 * Created: 04 January 2005 16:54:54
 * Modified: 04 January 2005 16:54:54
 */

@SuppressWarnings("serial")
public class IncorrectOrientationParameterException extends RuntimeException {

	public IncorrectOrientationParameterException() {
	}

	public IncorrectOrientationParameterException(String reason) {
		super(reason);
	}

}
