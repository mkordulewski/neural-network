package pl.kordulewski.ai.neuralnetwork;

import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunction;
import pl.kordulewski.ai.neuralnetwork.activation.BinaryStepFunction;
import pl.kordulewski.ai.neuralnetwork.generator.WeightGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Neuron implements Source, Serializable {

    private ActivationFunction activationFunction = new BinaryStepFunction();
    private List<Source> sources = new ArrayList<Source>();
    private List<Double> weights = new ArrayList<Double>();
    private WeightGenerator generator = new WeightGenerator();

    public void registerSource(Source source) {
        sources.add(source);
        weights.add(generator.nextRandomWeight());
    }

    public double getValue() {
        double result = 0;
        for (int i=0; i<sources.size();i++) {
            result += sources.get(i).getValue() * weights.get(i);
        }
        result = activationFunction.calculate(result);
        return result;
    }

    public List<Source> getSources() {
        return sources;
    }

}
