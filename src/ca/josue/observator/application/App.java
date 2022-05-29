package ca.josue.observator.application;

import ca.josue.observator.subscriber.PlayerPro;
import ca.josue.observator.subscriber.Subscriber;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class App {
    public static void main(String[] args) {
        // Create a new instance of the PlayerPro class
        Subscriber player1 = new PlayerPro("Josue");
        Subscriber player2 = new PlayerPro("Jonathan");

        Game game = new Game();
        game.addPlayer(player1);
        game.addPlayer(player2);

        // publish the event
        game.start();

        // remove the player
        game.removePlayer(player1);

        // new player added
        game.addPlayer(new PlayerPro("Juan"));
    }
}
