package it.test.tennis.logic;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
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
		// TODO: etc.
	}

	@Test
	public void testCheckDeuce() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckWinner() {
		fail("Not yet implemented");
	}

}
