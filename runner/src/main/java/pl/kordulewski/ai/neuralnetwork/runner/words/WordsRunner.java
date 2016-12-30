package pl.kordulewski.ai.neuralnetwork.runner.words;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionType;
import pl.kordulewski.ai.neuralnetwork.generator.NetworkGenerator;
import pl.kordulewski.ai.neuralnetwork.runner.words.generator.Generator;

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
        List<String> positiveLearningData = Generator.getInstance().generatePositiveInputData();
        List<String> negativeLearningData = Generator.getInstance().generateNegativeInputData();
        // show data
        System.out.println("Positive learning data [" + positiveLearningData.size() + "]:");
        for (String s : positiveLearningData) {
            System.out.println("  " + s);
        }
        System.out.println("Negative learning data [" + negativeLearningData.size() + "]:");
        for (String s : negativeLearningData) {
            System.out.println("  " + s);
        }
        // generate the network
        Network network = new NetworkGenerator().generate(ActivationFunctionType.UNIPOLAR_SIGMOIDAL, 32, 8, 1);
        // TODO learn the network
        // TODO test the network
    }

}
