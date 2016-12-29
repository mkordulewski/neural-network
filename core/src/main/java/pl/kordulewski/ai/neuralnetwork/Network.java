package pl.kordulewski.ai.neuralnetwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Network implements Serializable {

    private static final int NUMBER_OF_EPOCHS = 1000;

    List<Neuron> neuronsInInputLayer = new ArrayList<Neuron>();
    List<Neuron> neuronsInHiddenLayer = new ArrayList<Neuron>();
    List<Neuron> neuronsInOutputLayer = new ArrayList<Neuron>();

    public Network(List<Neuron> neuronsInInputLayer,
    List<Neuron> neuronsInHiddenLayer,
    List<Neuron> neuronsInOutputLayer) {
        if (neuronsInInputLayer==null || neuronsInHiddenLayer==null || neuronsInOutputLayer==null)
            throw new RuntimeException("null is not allowed");
        this.neuronsInInputLayer = neuronsInInputLayer;
        this.neuronsInHiddenLayer = neuronsInHiddenLayer;
        this.neuronsInOutputLayer = neuronsInOutputLayer;
    }

    public List<Neuron> getNeuronsInInputLayer() {
        return neuronsInInputLayer;
    }

    public List<Neuron> getNeuronsInHiddenLayer() {
        return neuronsInHiddenLayer;
    }

    public List<Neuron> getNeuronsInOutputLayer() {
        return neuronsInOutputLayer;
    }

    public void addInputData(List<Double> inputValues) {
        validateInputValues(inputValues);
        for(Neuron input:neuronsInInputLayer) {
            for(Double inputValue:inputValues) {
                input.registerSource(new StaticSource(inputValue));
            }
        }
    }

    public void learn(List<Double> expectedOutputValues) {
        // validate
        validateExpectedOutputValues(expectedOutputValues);
        // learn
        learnMultipleEpochs(expectedOutputValues, NUMBER_OF_EPOCHS);
    }

    protected void learnMultipleEpochs(List<Double> expectedOutputValues, int numberOfEpochs) {
        for (int epoch = 0; epoch<numberOfEpochs; epoch++) {
            // calculating output values
            for (Neuron neuron : getNeuronsInOutputLayer()) {
                neuron.getValue();
            }
            // expected values
            for (int i = 0; i < getNeuronsInOutputLayer().size(); i++) {
                getNeuronsInOutputLayer().get(i).expected(expectedOutputValues.get(i));
            }
            // correcting weights
            for (Neuron neuron : getNeuronsInOutputLayer()) {
                neuron.correctWeights();
            }
            // cleaning temporary variables
            for (Neuron neuron : getNeuronsInOutputLayer()) {
                neuron.clean();
            }
        }
    }

    protected void validateInputValues(List<Double> expectedOutputValues) {
        if (expectedOutputValues == null) {
            throw new RuntimeException("Input collection cannot be null");
        }
        for (Double d : expectedOutputValues) {
            if (d == null) {
                throw new RuntimeException("Input value cannot be null");
            }
        }
    }

    protected void validateExpectedOutputValues(List<Double> expectedOutputValues) {
        if (expectedOutputValues.size() != neuronsInOutputLayer.size()) {
            throw new RuntimeException("List sizes are not equal");
        }
        for (Double d : expectedOutputValues) {
            if (d == null) {
                throw new RuntimeException("Expected output value cannot be null");
            }
        }
    }

}
