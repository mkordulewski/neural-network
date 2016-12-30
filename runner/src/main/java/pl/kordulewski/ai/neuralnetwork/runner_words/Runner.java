package pl.kordulewski.ai.neuralnetwork.runner_words;

import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.generator.NetworkGenerator;
import pl.kordulewski.ai.neuralnetwork.runner_words.generator.Generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Runner {

    public static void main(String... arg) {
        new Runner().run();
    }

    public void run() {
        List<String> positiveLearningData = new Generator().generatePositiveInputData();
        // TODO generate negative learning data
        List<String> negativeLearningData = new ArrayList<>();
        System.out.println("Positive learning data [" + positiveLearningData.size() + "]:");
        for (String s : positiveLearningData) {
            System.out.println("  " + s);
        }
        System.out.println("Negative learning data [" + negativeLearningData.size() + "]:");
        for (String s : negativeLearningData) {
            System.out.println("  " + s);
        }
        // generate the network
        Network network = new NetworkGenerator().generate(32, 8, 1);
        // TODO learn the network
        // TODO generate random testing data
        // TODO test the network
    }

}
