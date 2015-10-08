package it.test.tennis.logic;

public enum GameStatus {
	UNSTARTED, STARTED, ENDED;
	
	public boolean isStarted() {
		if (this == STARTED) {
			return true;
		}
		return false;
	}
	
	public boolean isOver() {
		if (this == ENDED) {
			return true;
		}
		return false;
	}
}
