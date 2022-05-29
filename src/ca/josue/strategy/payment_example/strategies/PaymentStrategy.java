package ca.josue.strategy.payment_example.order;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public interface PaymentStrategy {
    boolean pay(int amount);
    boolean collectPaymentDetails();
}
