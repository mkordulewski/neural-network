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
        // TODO
        return result;
    }

    public String convertStringToBinary(String string) {
        if (string == null || "".equals(string))
            return "";
        return "0" + new BigInteger(string.getBytes()).toString(2);
    }

}
