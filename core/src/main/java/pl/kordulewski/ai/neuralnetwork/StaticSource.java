package pl.kordulewski.ai.neuralnetwork;

import java.io.Serializable;

/**
 * @author Michał Kordulewski
 */
public class StaticSource implements Source, Serializable {

    private double value = 0;

    public StaticSource(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
