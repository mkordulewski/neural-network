package pl.kordulewski.ai.neuralnetwork.runner.words.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Generator {

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

    public List<String> generateNegativeInputData() {
        List<String> result = new ArrayList<String>();
        for (String c1 : new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n", "o", "p", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "N", "O", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}) {
            for (String c2: new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}) {
                for (String c3: new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}) {
                    for (String c4: new String[]{"a", "b", "c", "d", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}) {
                        String word = c1 + c2 + c3 + c4;
                        result.add(word);
                    }
                }
            }
        }
        return result;
    }

    public List<Double> generateListOfDoubles(int size, double value) {
        List<Double> result = new ArrayList<Double>();
        for (int i=0; i<size; i++) {
            result.add(value);
        }
        return result;
    }

}
