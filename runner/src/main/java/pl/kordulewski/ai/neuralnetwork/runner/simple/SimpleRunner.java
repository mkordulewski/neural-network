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
public class SimpleRunner {

    public static void main(String... arg) {
        new SimpleRunner().run();
    }

    public void run() {
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 3, 3, 1);
        List<Double> inputValues1 = Arrays.asList(0.111, 0.222, 0.333);
        List<Double> expectedOutputData1 = Arrays.asList(0.0);
        List<Double> inputValues2 = Arrays.asList(0.666, 0.777, 0.888);
        List<Double> expectedOutputData2 = Arrays.asList(1.0);
        List<Double> testingInputValues = Arrays.asList(0.599, 0.523, 0.912);
        // testing before learning
        network.addInputData(inputValues1);
        System.out.print("output before learning: ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        // learning 1
        LearningData learningData1 = new LearningData(inputValues1, expectedOutputData1);
        LearningData learningData2 = new LearningData(inputValues2, expectedOutputData2);
        network.learn(Arrays.asList(learningData1));
//        network.learn(Arrays.asList(learningData1, learningData2));
        // testing after learning
        network.addInputData(inputValues1);
        System.out.print("output after learning:  ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        System.out.print("diff:                   ");
        System.out.format("%10.5f%n", Math.abs(expectedOutputData1.get(0).doubleValue() - network.getNeuronsInOutputLayer().get(0).getValue()));

        network.addInputData(inputValues2);
        System.out.print("output after learning:  ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        System.out.print("diff:                   ");
        System.out.format("%10.5f%n", Math.abs(expectedOutputData1.get(0).doubleValue() - network.getNeuronsInOutputLayer().get(0).getValue()));

        network.addInputData(testingInputValues);
        System.out.print("output after learning:  ");
        System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
        System.out.print("diff:                   ");
        System.out.format("%10.5f%n", Math.abs(expectedOutputData1.get(0).doubleValue() - network.getNeuronsInOutputLayer().get(0).getValue()));

    }
}
