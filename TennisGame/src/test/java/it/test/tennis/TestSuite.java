package it.test.tennis;

import it.test.tennis.logic.GameRulesTest;
import it.test.tennis.logic.ScoreTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/** Test Suite **/
@RunWith(Suite.class)
@Suite.SuiteClasses({AppTest.class, ScoreTest.class, GameRulesTest.class})
public class TestSuite {

}
