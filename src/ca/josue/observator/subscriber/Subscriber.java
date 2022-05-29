package ca.josue.observator.subscriber;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public interface Subscriber {
    String getName();
    void update(String message);
}