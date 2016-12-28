package pl.kordulewski.ai.neuralnetwork.data;

import java.util.List;

/**
 * @author Michał Kordulewski
 */
public abstract class AbstractInputData implements InputData {

    protected void validateInputData(List<Double> data) {
        if (data == null) {
            throw new RuntimeException("Input data collection cannot be null");
        }
        for (Double d : data) {
            if (d == null) {
                throw new RuntimeException("Input data cannot be null");
            }
        }
    }

}
