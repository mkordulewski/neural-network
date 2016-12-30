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
public class SimpleRunner331 {

    public static void main(String... arg) {
        new SimpleRunner331().run();
    }

    public void run() {
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 3, 3, 1);
        List<Double> inputValues = Arrays.asList(1.0, 0.0, 0.0);
        List<Double> expectedOutputData = Arrays.asList(1.0);
        // testing 1
        network.addInputData(inputValues);
        System.out.print("output before learning: ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        // learning 1
        network.learn(Arrays.asList(
            new LearningData(Arrays.asList(0.0, 0.0, 0.0), Arrays.asList(0.0)),
            new LearningData(inputValues, expectedOutputData),
            new LearningData(Arrays.asList(0.0, 1.0, 0.0), Arrays.asList(1.0)),
            new LearningData(Arrays.asList(0.0, 0.0, 1.0), Arrays.asList(1.0))
        ));
        // testing 2
        network.addInputData(inputValues);
        System.out.print("output after learning:  ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        System.out.print("diff:                   ");
        System.out.format("%10.5f%n", Math.abs(expectedOutputData.get(0).doubleValue() - network.getNeuronsInOutputLayer().get(0).getValue()));
    }
}
