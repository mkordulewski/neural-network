package pl.kordulewski.ai.neuralnetwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Network implements Serializable {

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

    public void learn(List<Double> expectedOutputValues) {
        if (expectedOutputValues.size() != neuronsInOutputLayer.size()) {
            throw new RuntimeException("List sizes are not equal");
        }
        // calculating output values
        for (Neuron neuron: getNeuronsInOutputLayer()) {
            neuron.getValue();
        }
        // expected values
        for (int i=0; i<getNeuronsInOutputLayer().size(); i++) {
            getNeuronsInOutputLayer().get(i).expected(expectedOutputValues.get(i));
        }
        // correcting weights
        for (Neuron neuron: getNeuronsInOutputLayer()) {
            neuron.correctWeights();
        }
        // cleaning temporary variables
        for (Neuron neuron: getNeuronsInOutputLayer()) {
            neuron.clean();
        }
    }

}
