package pl.kordulewski.ai.neuralnetwork.runner.words.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Michał Kordulewski
 */
public class Generator {

    private static final int NUMBER_OF_NEGATIVE_WORDS = 50;
    private static final int WORD_LENGTH = 4;

    private static Generator generator;
    private Random randomGenerator = new Random();

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

    public List<String> generateNegativeFromPositiveInputData(int multiplier) {
        List<String> positiveData = generatePositiveInputData();
        List<String> result = new ArrayList<>();
        for (String word: positiveData) {
            for (int k=0; k<multiplier;k++) {
                for (int i = 0; i < word.length(); i++) {
                    result.add(replaceChar(word, i, generateRandomChar()));
                }
            }
        }
        return result;
    }

    public String replaceChar(String text, int position, char newLetter) {
        return (position>0?text.substring(0,position):"") + newLetter + text.substring(position+1);
    }

    public char generateRandomChar() {
        char letter;
        int chooseLetterSize;
        chooseLetterSize = randomGenerator.nextInt(2);
        if (chooseLetterSize == 0) {
            int bigLetter = randomGenerator.nextInt(26) + 65;
            letter = (char) bigLetter;
        } else {
            int smallLetter = randomGenerator.nextInt(26) + 97;
            letter = (char) smallLetter;
        }
        return letter;
    }

    public String generateRandomLetter() {
        return "" + generateRandomChar();
    }

    public List<String> generateNegativeInputData(){
        List<String> negativeInputData = new ArrayList<>();
        char letter;
        int chooseLetterSize;
        for(int i = 0; i < NUMBER_OF_NEGATIVE_WORDS; i++) {
            StringBuilder builder = new StringBuilder();
            for(int j =0; j < WORD_LENGTH; j++ ) {
                chooseLetterSize = randomGenerator.nextInt(2);
                if (chooseLetterSize == 0) {
                    int bigLetter = randomGenerator.nextInt(26) + 65;
                    letter = (char) bigLetter;
                } else {
                    int smallLetter = randomGenerator.nextInt(26) + 97;
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
