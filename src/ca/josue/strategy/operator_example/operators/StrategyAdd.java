package ca.josue.strategy.operator_example.operators;

import ca.josue.strategy.operator_example.Strategy;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class StrategyAdd implements Strategy {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}
