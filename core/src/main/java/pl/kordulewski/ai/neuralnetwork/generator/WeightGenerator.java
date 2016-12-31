package pl.kordulewski.ai.neuralnetwork.generator;

import java.util.Random;

/**
 * @author Michał Kordulewski
 */
public class WeightGenerator {

    public final double min;
    public final double max;
    private static final Random generator = new Random();

    public WeightGenerator(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double nextRandomWeight() {
        double randomValue = min + (max - min) * generator.nextDouble();
        return randomValue;
    }

}
