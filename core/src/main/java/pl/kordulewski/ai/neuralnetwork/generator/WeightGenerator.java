package pl.kordulewski.ai.neuralnetwork.generator;

import java.util.Random;

/**
 * @author Michał Kordulewski
 */
public class WeightGenerator {

    public static final double MIN = -1;
    public static final double MAX = 1;
    private static final Random generator = new Random();
    private static WeightGenerator weightGenerator;

    public double nextRandomWeight() {
        double randomValue = MIN + (MAX - MIN) * generator.nextDouble();
        return randomValue;
    }

    public synchronized static WeightGenerator getInstance() {
        if (weightGenerator == null) {
            weightGenerator = new WeightGenerator();
        }
        return weightGenerator;
    }

}
