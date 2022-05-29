package ca.josue.strategy.payment_example.models;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
