package it.test.tennis.view;

import it.test.tennis.logic.Game;
import it.test.tennis.logic.Score;
import it.test.tennis.model.Player;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** View interface */
public class MessageBoard implements Board {
	// logger
	private static final Logger log = LogManager.getLogger(MessageBoard.class);

	public void printStartGame() {
		print(" ** Game started !");
	}
	
	/* (non-Javadoc)
	 * @see it.test.tennis.view.Board#printPlayerScoreMessage(it.test.tennis.model.Player)
	 */
	public void printPlayerScore(Player p) {
		// get message to print
		String message = getScoreMessage(p);
		
		// print message
		printDetail(message);
	}

	/* (non-Javadoc)
	 * @see it.test.tennis.view.Board#printWinner(it.test.tennis.model.Player, it.test.tennis.logic.Game)
	 */
	public void printWinner(Player winner, Game game) {
		print(" ** The winner is: "+winner.getName()+" -> "+getScore(game.getPlayer1(), game.getPlayer2()));
	}

	/* (non-Javadoc)
	 * @see it.test.tennis.view.Board#printAdvantage(it.test.tennis.model.Player, it.test.tennis.logic.Game)
	 */
	public void printAdvantage(Player advantage, Game game) {
		print("advantage -> "+getScore(game.getPlayer1(), game.getPlayer2()));
	}

	/* (non-Javadoc)
	 * @see it.test.tennis.view.Board#printDeuce(it.test.tennis.logic.Game)
	 */
	public void printDeuce(Game game) {
		print("deuce -> "+getScore(game.getPlayer1(), game.getPlayer2()));	
	}
	
	private String getScore(Player p1, Player p2) {
		return "["+p1.getScore()+"-"+p2.getScore()+"]";
	}
	
	private String getScoreMessage(Player p) {
		// player's score
		int value = p.getScore();
		
		Score score = Score.getScore(value);
		if (score!=null) {
			return "Player: "+p.getName()+" -> score: "+value+" ("+score.label()+")";
		} else {
			return "Player: "+p.getName()+" -> score: "+value;
		}
	}
	
	protected void printDetail(String message) {
		log.debug(message);
	}
	
	protected void print(String message) {
		log.info(message);
	}
}
