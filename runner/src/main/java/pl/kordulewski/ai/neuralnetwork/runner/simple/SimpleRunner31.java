package pl.kordulewski.ai.neuralnetwork.runner.simple;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionType;
import pl.kordulewski.ai.neuralnetwork.data.LearningData;
import pl.kordulewski.ai.neuralnetwork.generator.NetworkGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Logic OR gate modelled on neural network
 *
 * @author Michał Kordulewski
 */
public class SimpleRunner31 {

    public static void main(String... arg) {
        new SimpleRunner31().run();
    }

    public void run() {
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 3, 2, 1);
        List<LearningData> learningDataList = Arrays.asList(
                new LearningData(Arrays.asList(0.0, 0.0, 0.0), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(1.0, 0.0, 0.0), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.0, 1.0, 0.0), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.0, 0.0, 1.0), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(1.0, 1.0, 0.0), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(1.0, 0.0, 1.0), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.0, 1.0, 1.0), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(1.0, 1.0, 1.0), Arrays.asList(1.0))
        );
        List<LearningData> testingDataList = Arrays.asList(
                new LearningData(Arrays.asList(0.0, 0.0, 0.0), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.0, 0.0, 1.0), Arrays.asList(1.0))
        );
        // testing before learning
        network.addInputData(learningDataList.get(0).getInputValues());
        for (LearningData learningData: testingDataList) {
            network.addInputData(learningData.getInputValues());
            System.out.println();
            System.out.print("testing value        :  ");
            System.out.format("%10.5f%n", learningData.getInputValues().get(0));
            System.out.print("expected output      :  ");
            System.out.format("%10.5f%n", learningData.getExpectedOutputData().get(0).doubleValue());
            System.out.print("output BEFORE learning: ");
            System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
            System.out.print("diff:                   ");
            System.out.format("%10.5f%n", Math.abs(learningData.getExpectedOutputData().get(0).doubleValue() - network.getNeuronsInOutputLayer().get(0).getValue()));
        }
        System.out.println("\n*****************************************************************");
        // learning
        network.learn(learningDataList);
        // testing after learning
        for (LearningData learningData: testingDataList) {
            network.addInputData(learningData.getInputValues());
            System.out.println();
            System.out.print("testing value        :  ");
            System.out.format("%10.5f%n", learningData.getInputValues().get(0));
            System.out.print("expected output      :  ");
            System.out.format("%10.5f%n", learningData.getExpectedOutputData().get(0).doubleValue());
            System.out.print("output AFTER learning:  ");
            System.out.format("%10.5f%n", network.getNeuronsInOutputLayer().get(0).getValue());
            System.out.print("diff:                   ");
            System.out.format("%10.5f%n", Math.abs(learningData.getExpectedOutputData().get(0).doubleValue() - network.getNeuronsInOutputLayer().get(0).getValue()));
        }
        System.out.println("\nThe end");
    }
}
