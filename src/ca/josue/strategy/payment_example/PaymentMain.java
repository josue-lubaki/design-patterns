package ca.josue.strategy.payment_example;

import ca.josue.strategy.payment_example.models.Order;
import ca.josue.strategy.payment_example.models.Product;
import ca.josue.strategy.payment_example.strategies.PayByCreditCard;
import ca.josue.strategy.payment_example.strategies.PayByPayPal;
import ca.josue.strategy.payment_example.strategies.PaymentStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class PaymentMain {

    private static final Map<Integer, Product> products = new HashMap<>();
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final Order order = new Order();
    private static PaymentStrategy paymentStrategy;

    static {
        products.put(1, new Product("Laptop", 2000));
        products.put(2, new Product("Smartphone", 1000));
        products.put(3, new Product("Tablet", 500));
        products.put(4, new Product("TV", 1500));
    }

    public static void main(String[] args) throws IOException {
        while(!order.isClosed()){
            selectionProducts();
            selectionPaymentMethod();
            boolean canProcessPayment = order.processOrder(paymentStrategy);

            if(canProcessPayment){
                processPayment();
            }
        }
    }

    private static void processPayment() throws IOException {
        System.out.println("Pay " + order.getTotalCost() + " CAD or continue shopping [Process or Cancel] ? (P/C)");
        String option = READER.readLine();
        if(option.equalsIgnoreCase("P")){
            if(paymentStrategy.pay(order.getTotalCost())){
                System.out.println("Payment successful");
            } else{
                System.out.println("Payment failed");
            }
            order.setClosed();
        }
    }

    private static void selectionPaymentMethod() throws IOException {
        System.out.println("Select payment method: \n\t" +
                "1. Paypal \n\t" +
                "2. Credit Card");
        String option = READER.readLine();

        paymentStrategy = option.equals("1") ? new PayByPayPal() : new PayByCreditCard();
    }

    private static void selectionProducts() throws IOException {
        double cost;
        String continueChoice;

        do {
            System.out.println("Select a product:");
            products.forEach((k, v) -> System.out.println(k + " - " + v.getName() + " - " + v.getPrice()));
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(READER.readLine());

            if(choice == 0){
                System.out.println("Exiting...");
                System.exit(0);
            }

            cost = products.get(choice).getPrice();
            System.out.println("How many units of " + products.get(choice).getName() + " do you want to buy ? (Quantity)");
            int quantity = Integer.parseInt(READER.readLine());
            order.setTotalCost(cost * quantity);
            System.out.println("Total cost: " + order.getTotalCost() + " CAD");
            System.out.println("Do you want to continue? (Y/N)");
            continueChoice = READER.readLine();

        } while(continueChoice.equalsIgnoreCase("Y"));
    }
}
