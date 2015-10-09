package it.test.tennis.logic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import it.test.tennis.model.Player;

import org.junit.Before;
import org.junit.Test;

public class GameRulesTest {
	// local variable
	GameRules rules;
	// static
	static int id;
	
	@Before
	public void initGame() {
		rules = new GameRules();
		id = 0;
	}
	
	// utility method
	private static Player buildPlayerWithScore(int score) {
		return new Player("Player"+id, score);
	}

	@Test
	public void testCheckAdvantage() {
		assertNull(rules.checkAdvantage(buildPlayerWithScore(0), buildPlayerWithScore(0)));
		assertNull(rules.checkAdvantage(buildPlayerWithScore(0), buildPlayerWithScore(1)));
		assertNull(rules.checkAdvantage(buildPlayerWithScore(1), buildPlayerWithScore(0)));
		assertNull(rules.checkAdvantage(buildPlayerWithScore(1), buildPlayerWithScore(1)));
		assertNull(rules.checkAdvantage(buildPlayerWithScore(2), buildPlayerWithScore(0)));
		assertNull(rules.checkAdvantage(buildPlayerWithScore(3), buildPlayerWithScore(0)));
		assertNull(rules.checkAdvantage(buildPlayerWithScore(3), buildPlayerWithScore(3)));	// deuce
		assertNull(rules.checkAdvantage(buildPlayerWithScore(4), buildPlayerWithScore(4)));	// deuce
		assertNull(rules.checkAdvantage(buildPlayerWithScore(5), buildPlayerWithScore(5)));	// deuce
		assertNull(rules.checkAdvantage(buildPlayerWithScore(4), buildPlayerWithScore(0)));	// winner
		assertNull(rules.checkAdvantage(buildPlayerWithScore(5), buildPlayerWithScore(0)));	// winner
		assertNull(rules.checkAdvantage(buildPlayerWithScore(5), buildPlayerWithScore(3)));	// winner
		
		// advantage
		assertNotNull(rules.checkAdvantage(buildPlayerWithScore(4), buildPlayerWithScore(3)));
		assertNotNull(rules.checkAdvantage(buildPlayerWithScore(5), buildPlayerWithScore(4)));
		assertNotNull(rules.checkAdvantage(buildPlayerWithScore(6), buildPlayerWithScore(5)));
	}

	@Test
	public void testCheckDeuce() {
		assertFalse(rules.checkDeuce(buildPlayerWithScore(0), buildPlayerWithScore(0)));
		assertFalse(rules.checkDeuce(buildPlayerWithScore(0), buildPlayerWithScore(1)));
		assertFalse(rules.checkDeuce(buildPlayerWithScore(1), buildPlayerWithScore(0)));
		assertFalse(rules.checkDeuce(buildPlayerWithScore(1), buildPlayerWithScore(1)));
		assertFalse(rules.checkDeuce(buildPlayerWithScore(2), buildPlayerWithScore(0)));
		assertFalse(rules.checkDeuce(buildPlayerWithScore(2), buildPlayerWithScore(2)));
		assertFalse(rules.checkDeuce(buildPlayerWithScore(3), buildPlayerWithScore(0)));
		assertFalse(rules.checkDeuce(buildPlayerWithScore(4), buildPlayerWithScore(3)));	// advantage
		assertFalse(rules.checkDeuce(buildPlayerWithScore(5), buildPlayerWithScore(4)));	// advantage
		assertFalse(rules.checkDeuce(buildPlayerWithScore(6), buildPlayerWithScore(5)));	// advantage
		assertFalse(rules.checkDeuce(buildPlayerWithScore(4), buildPlayerWithScore(0)));	// winner
		assertFalse(rules.checkDeuce(buildPlayerWithScore(5), buildPlayerWithScore(0)));	// winner
		assertFalse(rules.checkDeuce(buildPlayerWithScore(5), buildPlayerWithScore(3)));	// winner
		
		// deuce
		assertTrue(rules.checkDeuce(buildPlayerWithScore(3), buildPlayerWithScore(3)));
		assertTrue(rules.checkDeuce(buildPlayerWithScore(4), buildPlayerWithScore(4)));
		assertTrue(rules.checkDeuce(buildPlayerWithScore(5), buildPlayerWithScore(5)));
		assertTrue(rules.checkDeuce(buildPlayerWithScore(6), buildPlayerWithScore(6)));
	}

	@Test
	public void testCheckWinner() {
		assertNull(rules.checkWinner(buildPlayerWithScore(0), buildPlayerWithScore(0)));
		assertNull(rules.checkWinner(buildPlayerWithScore(0), buildPlayerWithScore(1)));
		assertNull(rules.checkWinner(buildPlayerWithScore(1), buildPlayerWithScore(0)));
		assertNull(rules.checkWinner(buildPlayerWithScore(1), buildPlayerWithScore(1)));
		assertNull(rules.checkWinner(buildPlayerWithScore(2), buildPlayerWithScore(0)));
		assertNull(rules.checkWinner(buildPlayerWithScore(3), buildPlayerWithScore(0)));
		assertNull(rules.checkWinner(buildPlayerWithScore(3), buildPlayerWithScore(3)));	// deuce
		assertNull(rules.checkWinner(buildPlayerWithScore(4), buildPlayerWithScore(4)));	// deuce
		assertNull(rules.checkWinner(buildPlayerWithScore(5), buildPlayerWithScore(5)));	// deuce
		assertNull(rules.checkWinner(buildPlayerWithScore(4), buildPlayerWithScore(3)));	// advantage
		assertNull(rules.checkWinner(buildPlayerWithScore(5), buildPlayerWithScore(4)));	// advantage
		assertNull(rules.checkWinner(buildPlayerWithScore(6), buildPlayerWithScore(5)));	// advantage
		
		// winner
		assertNotNull(rules.checkWinner(buildPlayerWithScore(4), buildPlayerWithScore(0)));
		assertNotNull(rules.checkWinner(buildPlayerWithScore(5), buildPlayerWithScore(0)));
		assertNotNull(rules.checkWinner(buildPlayerWithScore(5), buildPlayerWithScore(3)));
	}

}
