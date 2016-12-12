package pl.kordulewski.ai.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class PositiveInputDataGenerator {

    public List<String> generate() {
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

}
