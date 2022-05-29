package ca.josue.strategy.operator_example;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class ContextApp {
    private final Strategy strategy;

    public ContextApp(Strategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double a, double b) {
        return strategy.execute(a, b);
    }
}
