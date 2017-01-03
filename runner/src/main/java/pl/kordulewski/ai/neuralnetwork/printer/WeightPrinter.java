package pl.kordulewski.ai.neuralnetwork.printer;

import pl.kordulewski.ai.neuralnetwork.Network;

/**
 * @author Michał Kordulewski
 */
public class WeightPrinter {

    private static WeightPrinter instance;

    public static WeightPrinter getInstance() {
        if (instance == null) {
            instance = new WeightPrinter();
        }
        return instance;
    }

    public void printWeights(Network network) {
        // TODO
    }

}
