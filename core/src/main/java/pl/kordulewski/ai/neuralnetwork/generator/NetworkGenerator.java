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

    public Network generate(int... number) {
        return generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, number);
    }

    public Network generate(ActivationFunctionType activationFunctionType, int... number) {
        List<List<Neuron>> list = new ArrayList<>();
        // generate list for each layer
        for (int i=0; i<number.length;i++) {
            list.add(new ArrayList<Neuron>());
        }
        // generate neurons
        for (int i=0; i<number.length;i++) {
            for (int j=0; j<number[i]; j++) {
                String name = "N." + (i + 1) + "." + (j + 1);
                System.out.println(name);
                list.get(i).add(new Neuron(activationFunctionType, name));
            }
        }
        // join layers
        for (int i=0; i<(number.length-1);i++) {
            for(Neuron input:list.get(i)) {
                for(Neuron hidden:list.get(i+1)) {
                    hidden.registerSource(input);
                }
            }
        }
        // generate network
        Network network = new Network(list);
        return network;
    }

}
