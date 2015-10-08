package it.test.tennis;

import org.apache.log4j.Logger;

import it.test.tennis.model.Player;

/** Game logic
 * 
 * @author matteo.capano
 *
 */
public class Game {
	// logger
	private static final Logger log = Logger.getLogger(Game.class);
	
	// game's players
	Player p1;
	Player p2;
	
	/** start of the game (init) **/
	public void start() {
		p1 = new Player(0,"Player 1");
		p2 = new Player(0,"Player 2");
		
		log.info(" ** Game started !");
	}
	
	public void gameLoop() {
		// TODO
	}
	
	public boolean isOver() {
		// TODO
		throw new RuntimeException("TODO");
	}
	
	public Player getWinner() {
		// TODO
		throw new RuntimeException("TODO");
	}
	
	public void updateScore() {
		// choice scoring player
		int playerID = scorePoint();
		
		// scoring player
		Player scoringPlayer = null;
		if (playerID==0) {
			scoringPlayer = p1;
		} else {
			scoringPlayer = p2;
		}
		
		// increment score for scoring player
		scoringPlayer.incrementScore();
		
		// print player's score
		printPlayerScoreMessage(scoringPlayer);
	}

	protected int scorePoint() {
		// random number in the interval [0,1]
		double random = Math.random();
		
		// 50% probability for each player
		if (random<0.5) {
			return 0;
		} else {
			return 1;
		}
	}
		
	protected void printPlayerScoreMessage(Player p) {
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
}
