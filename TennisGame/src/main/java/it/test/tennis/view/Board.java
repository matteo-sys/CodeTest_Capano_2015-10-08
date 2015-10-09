package it.test.tennis.view;

import it.test.tennis.logic.Game;
import it.test.tennis.model.Player;

public interface Board {

	public abstract void printPlayerScore(Player p);

	public abstract void printWinner(Player winner, Game game);

	public abstract void printAdvantage(Player advantage, Game game);

	public abstract void printDeuce(Game game);

	public abstract void printStartGame();

}