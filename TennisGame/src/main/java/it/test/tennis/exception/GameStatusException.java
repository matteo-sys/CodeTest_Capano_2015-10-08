package it.test.tennis.exception;

public class GameStatusException extends Exception {
	// serial UID
	private static final long serialVersionUID = 1L;

	public GameStatusException() {}
	
	public GameStatusException(String message) {
		super(message);
	}
}
