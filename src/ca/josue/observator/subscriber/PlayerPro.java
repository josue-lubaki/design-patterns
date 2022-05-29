package ca.josue.observator.subscriber;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class PlayerPro implements Subscriber {

    private final String name;

    public PlayerPro(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(String message) {
        System.out.println("(" + name + ") : " + message);
    }

    @Override
    public String toString() {
        return "PlayerPro " + name;
    }
}