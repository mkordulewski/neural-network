package pl.kordulewski.ai.neuralnetwork.data;

import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class LearningData extends AbstractData {

    private List<Double> inputData;

    public LearningData(List<Double> inputData) {
        validateInputData(inputData);
        this.inputData = inputData;
    }

    @Override
    public List<Double> getInputValues() {
        return inputData;
    }

}
