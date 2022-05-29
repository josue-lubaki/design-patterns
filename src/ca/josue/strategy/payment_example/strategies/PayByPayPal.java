package ca.josue.strategy.payment_example.strategies;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class PayByPayPal implements PaymentStrategy {

    private static final Map<String, String> DATABASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean isLoggedIn;

    static {
        DATABASE.put("user1@gmail.com", "user1");
        DATABASE.put("user2@gmail.com", "user2");
        DATABASE.put("user3@gmail.com", "user3");
    }

    @Override
    public boolean pay(int amount) {
        if (!isLoggedIn)
            return false;

        System.out.println("Paying " + amount + " CAD using PayPal");
        return true;
    }

    @Override
    public boolean collectPaymentDetails() {
        try{
            while (!isLoggedIn) {
                System.out.println("Enter your PayPal email address: ");
                this.email = READER.readLine();
                System.out.println("Enter your PayPal password: ");
                this.password = READER.readLine();

                if (connectToPayPal(email, password)) {
                    System.out.println("PayPal payment details collected successfully");
                    return true;
                } else {
                    System.out.println("Invalid email or password.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean connectToPayPal(String email, String password) {
        setLoggedIn(DATABASE.containsKey(email) && DATABASE.get(email).equals(password));
        return isLoggedIn;
    }


    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
