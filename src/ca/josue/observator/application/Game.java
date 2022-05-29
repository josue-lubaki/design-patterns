package ca.josue.observator.application;

import ca.josue.observator.publisher.GameEvent;
import ca.josue.observator.subscriber.Subscriber;

import java.util.ArrayList;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class Game {
    public GameEvent eventManager;

    public Game() {
        eventManager = new GameEvent(new ArrayList<>());
    }

    // add player
    public void addPlayer(Subscriber player) {
        eventManager.subscribe(player);
    }

    // remove player
    public void removePlayer(Subscriber player) {
        eventManager.unsubscribe(player);
    }

    public void start() {
        eventManager.notifySubscribers("Game has started");
    }
}
