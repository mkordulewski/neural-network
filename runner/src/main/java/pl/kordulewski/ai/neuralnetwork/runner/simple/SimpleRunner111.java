package pl.kordulewski.ai.neuralnetwork.runner.simple;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionType;
import pl.kordulewski.ai.neuralnetwork.data.Data;
import pl.kordulewski.ai.neuralnetwork.data.LearningData;
import pl.kordulewski.ai.neuralnetwork.data.TestingData;
import pl.kordulewski.ai.neuralnetwork.generator.NetworkGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Neural network returns value 1.0 if input data is equal or greater than 0.5. Otherwise returns value 0.0.
 *
 * @author Michał Kordulewski
 */
public class SimpleRunner111 {

    public static void main(String... arg) {
        new SimpleRunner111().run();
    }

    public void run() {
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 1, 1, 1);
        List<LearningData> learningDataList = Arrays.asList(
                new LearningData(Arrays.asList(0.0), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.1), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.2), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.33), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.45), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.5), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.51), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.55), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.6), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.6666), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.7), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.77), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.8), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(0.98), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(1.0), Arrays.asList(1.0))
        );
        List<LearningData> testingDataList = Arrays.asList(
                new LearningData(Arrays.asList(0.0), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.25), Arrays.asList(0.0)),
                new LearningData(Arrays.asList(0.7), Arrays.asList(1.0)),
                new LearningData(Arrays.asList(1.0), Arrays.asList(1.0))
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
    }
}
