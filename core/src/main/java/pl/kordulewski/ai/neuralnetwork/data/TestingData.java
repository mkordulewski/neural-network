package pl.kordulewski.ai.neuralnetwork.data;

import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class TestingData extends AbstractInputData {

    private List<Double> data;

    public TestingData(List<Double> data) {
        validateInputData(data);
        this.data = data;
    }

    @Override
    public List<Double> getInputValues() {
        return data;
    }

}
