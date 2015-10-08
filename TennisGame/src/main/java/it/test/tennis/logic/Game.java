package it.test.tennis.logic;

import it.test.tennis.exception.GameStatusException;
import it.test.tennis.model.Player;
import it.test.tennis.view.Board;

import org.apache.log4j.Logger;

/** Game logic.
 * 
 * NOTE: only 2 players/teams
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
	
	public Player getPlayer1() {
		return p1;
	}

	public Player getPlayer2() {
		return p2;
	}
	
	// game status
	private GameStatus status = GameStatus.UNSTARTED;
	
	// view board
	private Board board = new Board();
	
	Board getBoard() {
		return board;
	}
	
	public Game() {
		// init players
		p1 = new Player("Player 1", 0);
		p2 = new Player("Player 2", 0);
	}
	
	public Game(String nameP1, String nameP2) {
		// init players
		p1 = new Player(nameP1, 0);
		p2 = new Player(nameP2, 0);
	}
	
	/** start of the game (init) **/
	public void start() {
		// update status
		status = GameStatus.STARTED;
		
		log.info(" ** Game started !");
	}
	
	public void updateGame() throws GameStatusException {
		// validation on status
		if (status!=GameStatus.STARTED) {
			throw new GameStatusException("Game over or not started !");
		}
		
		// update score
		updateScore();
		
		// check rule to establish if game has a winner
		Player winner = checkWinner();
		if (winner!=null) {
			 gameOver();
			 
			 Board.printWinner(winner, this);
		}
	}

	private void gameOver() {
		status = GameStatus.ENDED;
	}

	public boolean isOver() {
		return status.isOver();
	}
	
	public void suspendMatch() {
		 gameOver();
	}
	
	public void forceScore(int scoreP1, int scoreP2) throws GameStatusException {
		if (p1==null || p2==null) {
			throw new GameStatusException("Players not created !");
		}
		
		// status
		status = GameStatus.STARTED;
		
		// score
		p1.setScore(scoreP1);
		p2.setScore(scoreP2);
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
		getBoard().printPlayerScoreMessage(scoringPlayer);
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
		
	protected Player checkWinner() {
		// TODO Auto-generated method stub
		return null;
	}
}
