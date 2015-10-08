package it.test.tennis.view;

import it.test.tennis.logic.Game;
import it.test.tennis.logic.Score;
import it.test.tennis.model.Player;

import org.apache.log4j.Logger;

/** View interface */
public class Board {
	// logger
	private static final Logger log = Logger.getLogger(Board.class);

	public void printPlayerScoreMessage(Player p) {
		// get message to print
		String message = getScoreMessage(p);
		
		// print message
		log.info(message);
	}
	
	private String getScoreMessage(Player p) {
		// player's score
		int value = p.getScore();
		
		Score score = Score.getScore(value);	
		if (score!=null) {
			return "Player: "+p.getName()+" -> score: "+score.label();
		} else {
			return "Player: "+p.getName()+" -> score: "+value;
		}
	}

	public static void printWinner(Player winner, Game game) {
		// TODO Auto-generated method stub
		
	}
}
