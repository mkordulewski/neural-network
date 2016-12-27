package pl.kordulewski.ai.neuralnetwork;

import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunction;
import pl.kordulewski.ai.neuralnetwork.activation.UnipolarStepFunction;
import pl.kordulewski.ai.neuralnetwork.generator.WeightGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Neuron implements Source, Serializable {

    private static final double LEARNING_RATE = 1;

    private ActivationFunction activationFunction = new UnipolarStepFunction();
    private List<Source> sources = new ArrayList<Source>();
    private List<Double> weights = new ArrayList<Double>();
    private WeightGenerator generator = new WeightGenerator();
    private Double cachedValue;
    private String name = "";
    private boolean corrected = false;
    private double sigma = 0;

    public Neuron() {
    }

    public Neuron(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void registerSource(Source source) {
        sources.add(source);
        weights.add(generator.nextRandomWeight());
    }

    public double getValue() {
        if (cachedValue != null) {
            return cachedValue;
        }
        double result = 0;
        for (int i=0; i<sources.size();i++) {
            result += sources.get(i).getValue() * weights.get(i);
        }
        result = activationFunction.calculate(result);
        cachedValue = result;
        return result;
    }

    public void expected(double expectedValue) {
        sigma(expectedValue - getValue());
    }

    public void sigma(double sigma) {
        for (int i=0; i<sources.size();i++) {
            if (sources.get(i) instanceof Neuron) {
                ((Neuron) sources.get(i)).sigma(sigma * weights.get(i));
            }
        }
        this.sigma += sigma;
    }

    public void correctWeights() {
        if (!corrected) {
            for (int i=0; i<sources.size();i++) {
                if (sources.get(i) instanceof Neuron) {
                    ((Neuron) sources.get(i)).correctWeights();
                }
            }
            // new weights
            for (int i=0; i<weights.size();i++) {
                double x = sources.get(i).getValue();
                weights.set(i, weights.get(i)+LEARNING_RATE*sigma*activationFunction.derivative( x ) * x);
            }
            corrected = true;
        }
    }

    public void clean() {
        corrected = false;
        sigma = 0;
        cachedValue = null;
        for (int i=0; i<sources.size();i++) {
            if (sources.get(i) instanceof Neuron) {
                ((Neuron) sources.get(i)).clean();
            }
        }
    }

    public List<Source> getSources() {
        return sources;
    }

}
