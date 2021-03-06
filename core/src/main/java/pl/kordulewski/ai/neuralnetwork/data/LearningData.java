package pl.kordulewski.ai.neuralnetwork.data;

import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class LearningData extends AbstractData {

    private List<Double> inputData;

    private List<Double> expectedOutputData;

    public LearningData(List<Double> inputData, List<Double> expectedOutputData) {
        validateInputData(inputData);
        validateInputData(expectedOutputData);
        this.inputData = inputData;
        this.expectedOutputData = expectedOutputData;
    }

    @Override
    public List<Double> getInputValues() {
        return inputData;
    }

    public List<Double> getExpectedOutputData() {
        return expectedOutputData;
    }

}
