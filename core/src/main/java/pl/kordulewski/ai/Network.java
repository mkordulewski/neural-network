package pl.kordulewski.ai;

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

}
