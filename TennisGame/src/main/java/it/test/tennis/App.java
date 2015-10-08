package it.test.tennis;

import org.apache.log4j.Logger;

import it.test.tennis.exception.GameStatusException;
import it.test.tennis.logic.Game;

/**
 * Hello world!
 *
 */
public class App implements Runnable
{
	// logger
	private static final Logger log = Logger.getLogger(App.class);
	
    public void run()
    {
        try {
        	// play the game
	        Game game = new Game();
			game.play();
		} catch (GameStatusException e) {
			log.error(e);
		}
    }
    
    public static void main( String[] args )
    {
    	//new App().run();
    	new Thread(new App()).start();
    }
}
