package it.test.tennis;

public enum Score {
	LOVE(0,"love"),
	FIFTEEN(1,"fifteen"),
	THIRTY(2,"thirty"),
	FORTY(3,"forty");
	
	private int value;
	private String label;
	
	Score(int value, String label) {
		this.value = value;
		this.label = label;
	}
	
	public int value() {
		return this.value;
	}
	
	public String label() {
		return this.label;
	}
	
	public String toString() {
		return label();
	}
	
	public static Score getScore(int value) {
		for (Score score : Score.values()) {
			if (score.value()==value) {
				return score;
			}
		}
		return null;
	}
}
