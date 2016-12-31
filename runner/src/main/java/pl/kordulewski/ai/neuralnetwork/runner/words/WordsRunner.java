package pl.kordulewski.ai.neuralnetwork.runner.words;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionType;
import pl.kordulewski.ai.neuralnetwork.data.LearningData;
import pl.kordulewski.ai.neuralnetwork.generator.NetworkGenerator;
import pl.kordulewski.ai.neuralnetwork.runner.words.converter.Converter;
import pl.kordulewski.ai.neuralnetwork.runner.words.generator.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class WordsRunner {

    public static void main(String... arg) {
        new WordsRunner().run();
    }

    public void run() {
        // preparing data
        List<String> positiveStringLearningData = Generator.getInstance().generatePositiveInputData();
        List<String> negativeStringLearningData = Generator.getInstance().generateNegativeInputData();
        List<LearningData> positiveLearningDataList = new ArrayList<>();
        for (String word : positiveStringLearningData) {
            List<Double> inputData = Converter.getInstance().convert(word);
            List<Double> expectedResult = Arrays.asList(1.0);
            positiveLearningDataList.add(new LearningData(inputData, expectedResult));
        }
        List<LearningData> negativeLearningDataList = new ArrayList<>();
        for (String word : negativeStringLearningData) {
            List<Double> inputData = Converter.getInstance().convert(word);
            List<Double> expectedResult = Arrays.asList(0.0);
            negativeLearningDataList.add(new LearningData(inputData, expectedResult));
        }
        // show data
        System.out.println("Positive learning data [elements: " + positiveStringLearningData.size() + "]:");
        for (String s : positiveStringLearningData) {
            System.out.println("  " + s);
        }
        int howManyFirstElements = 20;
        System.out.println("Negative learning data [elements: " + negativeStringLearningData.size() + "] - first " + howManyFirstElements + ":");
        for (int i = 0; i < howManyFirstElements && i < negativeStringLearningData.size(); i++) {
            System.out.println("  " + negativeStringLearningData.get(i));
        }
        // generate the network
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 32, 8, 1);
        // TODO learn the network
        // TODO test the network
    }

}
