package it.test.tennis.model;

public class Player {
	// fields
	private int score;
	private String name = "";
	
	public Player() {}
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void incrementScore() {
		this.score++;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name+" -> current score: "+score;
	}
}
