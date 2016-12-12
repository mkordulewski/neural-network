package pl.kordulewski.ai;

import pl.kordulewski.ai.generator.PositiveInputDataGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Runner {

    public static void main(String... arg) {
        List<String> positiveLearningData = new PositiveInputDataGenerator().generate();
        // TODO generate negative learning data
        List<String> negativeLearningData = new ArrayList<>();
        System.out.println("Positive learning data:");
        for (String s : positiveLearningData) {
            System.out.println("  " + s);
        }
        System.out.println("Negative learning data:");
        for (String s : negativeLearningData) {
            System.out.println("  " + s);
        }
        // TODO generate the network
        // TODO learn the network
        // TODO generate random testing data
        // TODO test the network
    }

}
