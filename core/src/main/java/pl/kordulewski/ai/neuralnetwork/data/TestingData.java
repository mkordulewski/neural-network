package pl.kordulewski.ai.neuralnetwork.data;

import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class TestingData extends AbstractInputData {

    private List<Double> inputData;

    public TestingData(List<Double> inputData) {
        validateInputData(inputData);
        this.inputData = inputData;
    }

    @Override
    public List<Double> getInputValues() {
        return inputData;
    }

}
