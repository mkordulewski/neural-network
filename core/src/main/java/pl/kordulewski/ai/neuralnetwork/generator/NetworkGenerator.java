package pl.kordulewski.ai.neuralnetwork.generator;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.Neuron;
import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class NetworkGenerator {

    public Network generate(int numberOfNeuronsInInputLayer, int numberOfNeuronsInHiddenLayer, int numberOfNeuronsInOutputLayer) {
        return generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, numberOfNeuronsInInputLayer, numberOfNeuronsInHiddenLayer, numberOfNeuronsInOutputLayer);
    }

    public Network generate(ActivationFunctionType activationFunctionType, int... number) {
        return generate(activationFunctionType, number[0], number[1], number[2]);
    }

    private Network generate(ActivationFunctionType activationFunctionType, int numberOfNeuronsInInputLayer, int numberOfNeuronsInHiddenLayer, int numberOfNeuronsInOutputLayer) {
        List<Neuron> neuronsInInputLayer = new ArrayList<Neuron>();
        List<Neuron> neuronsInHiddenLayer = new ArrayList<Neuron>();
        List<Neuron> neuronsInOutputLayer = new ArrayList<Neuron>();
        for(int i=0; i<numberOfNeuronsInInputLayer; i++) {
            neuronsInInputLayer.add(new Neuron(activationFunctionType, "N.1."+(i+1)));
        }
        for(int i=0; i<numberOfNeuronsInHiddenLayer; i++) {
            neuronsInHiddenLayer.add(new Neuron(activationFunctionType, "N.2."+(i+1)));
        }
        for(int i=0; i<numberOfNeuronsInOutputLayer; i++) {
            neuronsInOutputLayer.add(new Neuron(activationFunctionType, "N.3."+(i+1)));
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
