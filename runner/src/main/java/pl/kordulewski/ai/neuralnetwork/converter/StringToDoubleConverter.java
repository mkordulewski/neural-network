package pl.kordulewski.ai.neuralnetwork.converter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class StringToDoubleConverter {

    public List<Double> convert(String word) {
        List<Double> result = new ArrayList<Double>();
        if (word == null) {
            return result;
        }
        String binary = convertStringToBinary(word);
        for(int i=0;i<(binary.length());i++) {
            char c = binary.charAt(i);
            result.add(convertCharToDouble(c));
        }
        return result;
    }

    public String convertStringToBinary(String string) {
        if (string == null || "".equals(string))
            return "";
        return "0" + new BigInteger(string.getBytes()).toString(2);
    }

    public double convertCharToDouble(char c) {
        if (c == '0') {
            return -1.0;
        } else if (c == '1') {
            return 1.0;
        }
        throw new RuntimeException("not-acceptable value");
    }

}
