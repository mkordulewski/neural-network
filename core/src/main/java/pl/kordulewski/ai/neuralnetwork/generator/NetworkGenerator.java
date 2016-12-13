package pl.kordulewski.ai.neuralnetwork.generator;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.Neuron;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class NetworkGenerator {

    public Network generate(int numberOfNeuronsInInputLayer, int numberOfNeuronsInHiddenLayer, int numberOfNeuronsInOutputLayer) {
        List<Neuron> neuronsInInputLayer = new ArrayList<Neuron>();
        List<Neuron> neuronsInHiddenLayer = new ArrayList<Neuron>();
        List<Neuron> neuronsInOutputLayer = new ArrayList<Neuron>();
        for(int i=0; i<numberOfNeuronsInInputLayer; i++) {
            neuronsInInputLayer.add(new Neuron());
        }
        for(int i=0; i<numberOfNeuronsInHiddenLayer; i++) {
            neuronsInHiddenLayer.add(new Neuron());
        }
        for(int i=0; i<numberOfNeuronsInOutputLayer; i++) {
            neuronsInOutputLayer.add(new Neuron());
        }
        // join neuronsInInputLayer and neuronsInHiddenLayer each other
        for(Neuron input:neuronsInInputLayer) {
            for(Neuron hidden:neuronsInHiddenLayer) {
                hidden.registerSource(input);
            }
        }
        // join neuronsInHiddenLayer and neuronsInOutputLayer each other
        for(Neuron hidden:neuronsInHiddenLayer) {
            for(Neuron output:neuronsInOutputLayer) {
                output.registerSource(hidden);
            }
        }
        // network
        Network network = new Network(neuronsInInputLayer, neuronsInHiddenLayer, neuronsInOutputLayer);
        return network;
    }

}