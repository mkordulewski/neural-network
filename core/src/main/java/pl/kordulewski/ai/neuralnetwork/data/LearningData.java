package pl.kordulewski.ai.neuralnetwork.data;

import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class LearningData extends AbstractInputData {

    private List<Double> data;

    public LearningData(List<Double> data) {
        validateInputData(data);
        this.data = data;
    }

    @Override
    public List<Double> getInputValues() {
        return data;
    }

}
