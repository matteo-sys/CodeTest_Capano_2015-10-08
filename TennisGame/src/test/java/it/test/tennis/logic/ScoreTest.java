package it.test.tennis.logic;

import static org.junit.Assert.*;
import it.test.tennis.logic.Score;

import org.junit.Test;

public class ScoreTest {
	// array of expected results
	String[] expectedResults = { "love","fifteen","thirty","forty" };
	
	@Test
	public void testGetScore() {
		for (int i=0; i<expectedResults.length; i++) {
			assertEquals(expectedResults[i], Score.getScore(i).label());
		}
	}
}
