package pl.kordulewski.ai.neuralnetwork.runner.words.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Michał Kordulewski
 */
public class Generator {

    private static final int NUMBER_OF_WORDS = 100;
    private static final int WORD_LENGTH = 4;

    private static Generator generator;

    public static Generator getInstance() {
        if (generator == null) {
            generator = new Generator();
        }
        return generator;
    }

    public List<String> generatePositiveInputData() {
        List<String> result = new ArrayList<String>();
        for (String c1: new String[]{"m", "M"}) {
            for (String c2: new String[]{"i", "I"}) {
                for (String c3: new String[]{"k", "K"}) {
                    for (String c4: new String[]{"e", "E"}) {
                        String word = c1 + c2 + c3 + c4;
                        result.add(word);
                    }
                }
            }
        }
        return result;
    }

    public List<String> generateNegativeInputData(){
        Random generator = new Random();
        List<String> negativeInputData = new ArrayList<>();
        char letter;
        int chooseLetterSize;
        for(int i = 0; i < NUMBER_OF_WORDS; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j =0; j < WORD_LENGTH; j++ ) {
                chooseLetterSize = generator.nextInt(2);
                if (chooseLetterSize == 0) {
                    int bigLetter = generator.nextInt(26) + 65;
                    letter = (char) bigLetter;
                } else {
                    int smallLetter = generator.nextInt(26) + 97;
                    letter = (char) smallLetter;
                }
                builder.append(letter);
            }
            negativeInputData.add(builder.toString());
        }
        return negativeInputData;
    }

    public List<Double> generateListOfDoubles(int size, double value) {
        List<Double> result = new ArrayList<Double>();
        for (int i=0; i<size; i++) {
            result.add(value);
        }
        return result;
    }

}
