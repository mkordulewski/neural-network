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
        List<Double> inputValues = Arrays.asList(0.7);
        List<Double> expectedOutputData = Arrays.asList(1.0);
        // testing before learning
        network.addInputData(inputValues);
        System.out.print("output before learning: ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        // learning
        network.learn(Arrays.asList(
                new LearningData(Arrays.asList(0.0), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.1), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.2), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.33), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.45), Arrays.asList(0.0)),
                new LearningData(inputValues, expectedOutputData),
                new LearningData(Arrays.asList(0.5), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.51), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.55), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.6), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.6666), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.77), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.8), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.98), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(1.0), Arrays.asList(1.0))
        ));
        // testing after learning
        network.addInputData(inputValues);
        System.out.print("output after learning:  ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        System.out.print("diff:                   ");
        System.out.format("%10.5f%n", Math.abs(expectedOutputData.get(0).doubleValue() - network.getNeuronsInOutputLayer().get(0).getValue()));
    }
}
