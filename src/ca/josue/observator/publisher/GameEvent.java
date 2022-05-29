package ca.josue.observator.publisher;

import ca.josue.observator.subscriber.Subscriber;

import java.util.List;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */

public class GameEvent {
    private final List<Subscriber> listPlayers;

    public GameEvent(List<Subscriber> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public void subscribe(Subscriber player){
        notifyPlayers(player);
        this.listPlayers.add(player);
    }

    public void unsubscribe(Subscriber player){
        this.listPlayers.remove(player);
    }

    public void notifyPlayers(Subscriber player){
        for(Subscriber playerSubscriber : listPlayers){
            playerSubscriber.update("Nouveau joueur [" + player.getName() + "] a rejoint la partie");
        }
    }

    public void notifySubscribers(String message) {
        for(Subscriber playerSubscriber : listPlayers){
            playerSubscriber.update(message);
        }
    }
}