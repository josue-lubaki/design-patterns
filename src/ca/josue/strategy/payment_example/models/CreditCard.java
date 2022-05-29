package ca.josue.strategy.payment_example.order.models;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class CreditCard {
    private final String name;
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;
    private int amount;

    public CreditCard(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.amount = 2000;
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
