package ca.josue.strategy.payment_example.order.models;

import ca.josue.strategy.payment_example.order.PaymentStrategy;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public boolean processOrder(PaymentStrategy strategy) {
       return strategy.collectPaymentDetails();
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost += totalCost;
    }

    public void setClosed() {
        isClosed = true;
    }
}
