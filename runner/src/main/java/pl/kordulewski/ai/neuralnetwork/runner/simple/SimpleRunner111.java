package pl.kordulewski.ai.neuralnetwork.runner.simple;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionType;
import pl.kordulewski.ai.neuralnetwork.data.LearningData;
import pl.kordulewski.ai.neuralnetwork.generator.NetworkGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class SimpleRunner111 {

    public static void main(String... arg) {
        new SimpleRunner111().run();
    }

    public void run() {
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 1, 1, 1);
        List<Double> inputValues = Arrays.asList(0.666);
        List<Double> expectedOutputData = Arrays.asList(1.0);
        // testing 1
        network.addInputData(inputValues);
        System.out.print("output before learning: ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        // learning 1
        LearningData learningData = new LearningData(inputValues, expectedOutputData);
        network.learn(Arrays.asList(learningData));
        // testing 2
        network.addInputData(inputValues);
        System.out.print("output after learning:  ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        System.out.print("diff:                   ");
        System.out.format("%10.5f%n", Math.abs(expectedOutputData.get(0).doubleValue() - network.getNeuronsInOutputLayer().get(0).getValue()));
    }
}
