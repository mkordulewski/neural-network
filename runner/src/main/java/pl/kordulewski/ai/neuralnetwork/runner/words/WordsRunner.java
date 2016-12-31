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

    private static final double INTERPRET_THRESHOLD = 0.8;
    private static final double VALUE_TRUE = 1.0;
    private static final double VALUE_FALSE = 0.0;
    private static final String MESSAGE_LEARNING = "Learning in progres...";
    private static final String MESSAGE_RESULTS = "Testing results: ";
    private String testingWord;
    private double testingResult;

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
            List<Double> expectedResult = Arrays.asList(VALUE_TRUE);
            positiveLearningDataList.add(new LearningData(inputData, expectedResult));
        }
        List<LearningData> negativeLearningDataList = new ArrayList<>();
        for (String word : negativeStringLearningData) {
            List<Double> inputData = Converter.getInstance().convert(word);
            List<Double> expectedResult = Arrays.asList(VALUE_FALSE);
            negativeLearningDataList.add(new LearningData(inputData, expectedResult));
        }
        List<LearningData> allLearningDataList = new ArrayList<>();
        allLearningDataList.addAll(positiveLearningDataList);
        allLearningDataList.addAll(negativeLearningDataList);
        // show data
        System.out.println("Positive learning data [elements: " + positiveStringLearningData.size() + "]:");
        for (String s : positiveStringLearningData) {
            System.out.println("  " + s);
        }
        int howManyFirstElementsToShow = 10;
        System.out.println("Negative learning data [elements: " + negativeStringLearningData.size() + "] - first " + howManyFirstElementsToShow + ":");
        for (int i = 0; i < howManyFirstElementsToShow && i < negativeStringLearningData.size(); i++) {
            System.out.println("  " + negativeStringLearningData.get(i));
        }
        // generate the network
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 28, 8, 1);
        // learning the network
        System.out.println(MESSAGE_LEARNING);
        network.learn(allLearningDataList);
        System.out.println(MESSAGE_RESULTS);
        // testing the network: 1
        List<String> testingWords = Arrays.asList(
                "MIKE",
                "mike",
                "mika",
                "mixy",
                "ABCD",
                "XYZA"
        );
        for (String testingWord : testingWords) {
            network.addInputData(Converter.getInstance().convert(testingWord));
            testingResult = network.getNeuronsInOutputLayer().get(0).getValue();
            System.out.println("  "+ testingWord + " -> " + interpretResult(testingResult) + " [" + testingResult + "]");
        }
    }

    private boolean interpretResult(double result) {
        if (result > INTERPRET_THRESHOLD) {
            return true;
        } else {
            return false;
        }
    }

}
