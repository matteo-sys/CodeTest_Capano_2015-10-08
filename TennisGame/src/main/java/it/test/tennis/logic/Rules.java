package it.test.tennis.logic;

import it.test.tennis.model.Player;

public interface Rules {

	public abstract Player getScoringPlayer(Player p1, Player p2);

	public abstract Player checkAdvantage(Player p1, Player p2);

	public abstract boolean checkDeuce(Player p1, Player p2);

	public abstract Player checkWinner(Player p1, Player p2);

}