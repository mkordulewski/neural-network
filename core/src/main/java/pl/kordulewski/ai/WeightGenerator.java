package pl.kordulewski.ai;

import java.util.Random;

/**
 * @author Michał Kordulewski
 */
public class WeightGenerator {

    public static final double MIN = -1;
    public static final double MAX = 1;
    private static final Random generator = new Random();

    public double nextRandomWeight() {
        double randomValue = MIN + (MAX - MIN) * generator.nextDouble();
        return 0;
    }

}
