package it.test.tennis.logic;

import it.test.tennis.model.Player;

public class GameRules implements Rules {

	/* (non-Javadoc)
	 * @see it.test.tennis.logic.Rules#getScoringPlayer(it.test.tennis.model.Player, it.test.tennis.model.Player)
	 */
	public Player getScoringPlayer(Player p1, Player p2) {
		// random number in the interval [0,1]
		double random = Math.random();
		
		// 50% probability for each player
		if (random<0.5) {
			return p1;
		} else {
			return p2;
		}
	}
	
	/* (non-Javadoc)
	 * @see it.test.tennis.logic.Rules#checkAdvantage(it.test.tennis.model.Player, it.test.tennis.model.Player)
	 */
	public Player checkAdvantage(Player p1, Player p2) {
		int s1 = p1.getScore();
		int s2 = p2.getScore();
		
		if (s1>=3 && s2>=3) {
			if (s1>s2)
				return p1;
			else if (s2>s1) {
				return p2;
			}
		}
		// default -> no advantage
		return null;
	}
	
	/* (non-Javadoc)
	 * @see it.test.tennis.logic.Rules#checkDeuce(it.test.tennis.model.Player, it.test.tennis.model.Player)
	 */
	public boolean checkDeuce(Player p1, Player p2) {
		int s1 = p1.getScore();
		int s2 = p2.getScore();
		
		if (s1>=3 && s2>=3) {
			if (s1==s2)
				return true;
		}
		// default -> no deuce
		return false;
	}
	
	/* (non-Javadoc)
	 * @see it.test.tennis.logic.Rules#checkWinner(it.test.tennis.model.Player, it.test.tennis.model.Player)
	 */
	public Player checkWinner(Player p1, Player p2) {
		int s1 = p1.getScore();
		int s2 = p2.getScore();
		
		if (s1>=4 && s1-s2>=2) {
			return p1;
		} else if (s2>=4 && s2-s1>=2) {
			return p2;
		} else {
			// default -> no winner
			return null;
		}
	}
}
