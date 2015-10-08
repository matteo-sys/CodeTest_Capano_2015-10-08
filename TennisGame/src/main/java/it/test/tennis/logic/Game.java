package it.test.tennis.logic;

import it.test.tennis.exception.GameStatusException;
import it.test.tennis.model.Player;
import it.test.tennis.view.Board;
import it.test.tennis.view.MessageBoard;

/** Game logic.
 * 
 * NOTE: only 2 players
 * 
 * @author matteo.capano
 *
 */
public class Game {
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
	protected GameStatus status = GameStatus.UNSTARTED;
	
	// game rules
	protected Rules rules = new GameRules();
	
//	protected Rules getRules() {
//		return rules;
//	}
	
	// view board
	protected Board board = new MessageBoard();
	
//	public Board getBoard() {
//		return board;
//	}
	
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
	
	public Game(String nameP1, String nameP2, Rules rules, Board board) {
		this(nameP1, nameP2);
		this.board = board;
		this.rules = rules;
	}
	
	/** start of the game (init) **/
	private void start() {
		// update status
		status = GameStatus.STARTED;
		
		// print start game
		board.printStartGame();
		
		// print initial score
		board.printPlayerScoreMessage(p1);
		board.printPlayerScoreMessage(p2);
	}
	
	public void play() throws GameStatusException {
		// update status
		start();
		
		// game loop
		while (! isOver()) {
			updateGame();
		}
	}
	
	public void updateGame() throws GameStatusException {
		// validation on status
		if (status!=GameStatus.STARTED) {
			throw new GameStatusException("Game over or not started !");
		}
		
		// update score
		updateScore();
		
		// advantage
		Player advantage = rules.checkAdvantage(p1, p2);
		if (advantage!=null) {
			board.printAdvantage(advantage, this);
		}
		
		// deuce
		boolean deuce = rules.checkDeuce(p1, p2);
		if (deuce) {
			board.printDeuce(this);
		}
		
		// check rule to establish if game has a winner
		Player winner = rules.checkWinner(p1, p2);
		if (winner!=null) {
			 gameOver();
			 
			 board.printWinner(winner, this);
		}
	}

	protected void gameOver() {
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
		// scoring player
		Player scoringPlayer = rules.getScoringPlayer(p1, p2);
		
		// increment score for scoring player
		scoringPlayer.incrementScore();
		
		// print player's score
		board.printPlayerScoreMessage(scoringPlayer);
	}
}
