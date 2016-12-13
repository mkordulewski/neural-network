package pl.kordulewski.ai.neuralnetwork.generator;

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

    public List<Double> generateListOfDoubles(int size, double value) {
        List<Double> result = new ArrayList<Double>();
        for (int i=0; i<size; i++) {
            result.add(value);
        }
        return result;
    }

}
