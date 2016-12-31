package pl.kordulewski.ai.neuralnetwork.runner.words.converter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Converter {

    private static final int BITS = 7;

    private static Converter converter;

    public static Converter getInstance() {
        if (converter == null) {
            converter = new Converter();
        }
        return converter;
    }

    public List<Double> convert(String word) {
        List<Double> result = new ArrayList<Double>();
        if (word == null) {
            return result;
        }
        for (int i=0; i<word.length();i++) {
            String s = convertStringToBinary("" + word.charAt(i));
            for (int j=0; j<s.length();j++) {
                result.add(convertCharToDouble(s.charAt(j)));
            }
        }
        return result;
    }

    /**
     * Returns string of zeros and ones representing bits.
     */
    public String convertStringToBinary(String string) {
        if (string == null || "".equals(string))
            return "";
        String result = new BigInteger(string.getBytes()).toString(2);
        if (result.length() < BITS) {
            int diff = BITS - result.length();
            for (int i=0; i<diff; i++) {
                result = "0" + result;
            }
        }
        return result;
    }

    /**
     * Method accepts param 'c' with value '0' and '1' only. Char value '0' is converted into double value 0.0, char value '1' is converted into double value 1.0.
     */
    public double convertCharToDouble(char c) {
        if (c == '0') {
            return 0.0;
        } else if (c == '1') {
            return 1.0;
        }
        throw new RuntimeException("not-acceptable value");
    }

}
