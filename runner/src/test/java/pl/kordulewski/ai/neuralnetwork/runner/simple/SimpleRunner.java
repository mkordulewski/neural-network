package pl.kordulewski.ai.neuralnetwork.runner.simple;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionType;
import pl.kordulewski.ai.neuralnetwork.data.LearningData;
import pl.kordulewski.ai.neuralnetwork.generator.NetworkGenerator;
import pl.kordulewski.ai.neuralnetwork.runner_words.generator.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class SimpleRunner {

    public static void main(String... arg) {
        new SimpleRunner().run();
    }

    public void run() {
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 3, 3, 1);
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
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(3);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(3);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(1);
    }
}
