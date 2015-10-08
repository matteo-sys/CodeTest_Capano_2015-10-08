package it.test.tennis;

/**
 * Hello world!
 *
 */
public class App implements Runnable
{
    public void run()
    {
        Game game = new Game();
        // NOT TESTED YET
        game.start();
    }
    
    public static void main( String[] args )
    {
    	new App().run();
    }
}
