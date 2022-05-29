package ca.josue.strategy.payment_example.order.strategies;

import ca.josue.strategy.payment_example.order.PaymentStrategy;
import ca.josue.strategy.payment_example.order.models.CreditCard;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class PayByCreditCard implements PaymentStrategy {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;

    @Override
    public boolean pay(int amount) {
        if(!cardIsPresent())
            return false;

        // if amount is greater than the amount in the credit card, return false
        if(amount > creditCard.getAmount()){
            System.out.println("Insufficient funds");
            return false;
        }

        System.out.println("Paying " + amount + " CAD using credit card");
        creditCard.setAmount(creditCard.getAmount() - amount);
        return true;
    }

    @Override
    public boolean collectPaymentDetails() {
        try {
            System.out.println("Enter your name: ");
            String name = reader.readLine();
            System.out.println("Enter your card number: ");
            String cardNumber = reader.readLine();
            System.out.println("Enter your CVV: ");
            String cvv = reader.readLine();
            System.out.println("Enter your expiry date (MM/YYYY): ");
            String expiryDate = reader.readLine();

            creditCard = new CreditCard(name, cardNumber, cvv, expiryDate);

            // validate credit card
            return validateCreditCard(creditCard);

        } catch (Exception e) {
            System.out.println("Error while collecting payment details : " + e.getMessage());
        }

        return false;
    }

    /**
     * Method to validate credit card
     * @param creditCard CreditCard object to validate
     * @return true if credit card is valid, false otherwise
     * */
    private boolean validateCreditCard(CreditCard creditCard) {
        if(!creditCard.getCardNumber().startsWith("4")){
            throw new IllegalArgumentException("Only visa cards are accepted");
        }

        if(creditCard.getExpiryDate().length() != 7){
            throw new IllegalArgumentException("Invalid expiry date");
        }

        if(creditCard.getCvv().length() != 3){
            throw new IllegalArgumentException("Invalid CVV");
        }

        return true;
    }

    private boolean cardIsPresent() {
        return creditCard != null;
    }
}
