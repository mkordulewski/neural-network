package pl.kordulewski.ai.neuralnetwork.data;

import java.util.List;

/**
 * @author Michał Kordulewski
 */
public abstract class AbstractData implements Data {

    protected void validateInputData(List<Double> data) {
        if (data == null) {
            throw new RuntimeException("Data collection cannot be null");
        }
        for (Double d : data) {
            if (d == null) {
                throw new RuntimeException("Data value cannot be null");
            }
        }
    }

}
