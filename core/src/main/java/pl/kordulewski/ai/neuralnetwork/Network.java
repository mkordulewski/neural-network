package pl.kordulewski.ai.neuralnetwork;

import pl.kordulewski.ai.neuralnetwork.data.LearningData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Network implements Serializable {

    private static final int NUMBER_OF_EPOCHS = 1000;

    List<Neuron> neuronsInInputLayer = new ArrayList<Neuron>();
    List<Neuron> neuronsInHiddenLayer = new ArrayList<Neuron>();
    List<Neuron> neuronsInOutputLayer = new ArrayList<Neuron>();

    public Network(List<Neuron> neuronsInInputLayer,
    List<Neuron> neuronsInHiddenLayer,
    List<Neuron> neuronsInOutputLayer) {
        if (neuronsInInputLayer==null || neuronsInHiddenLayer==null || neuronsInOutputLayer==null)
            throw new RuntimeException("null is not allowed");
        this.neuronsInInputLayer = neuronsInInputLayer;
        this.neuronsInHiddenLayer = neuronsInHiddenLayer;
        this.neuronsInOutputLayer = neuronsInOutputLayer;
    }

    public List<Neuron> getNeuronsInInputLayer() {
        return neuronsInInputLayer;
    }

    public List<Neuron> getNeuronsInHiddenLayer() {
        return neuronsInHiddenLayer;
    }

    public List<Neuron> getNeuronsInOutputLayer() {
        return neuronsInOutputLayer;
    }

    protected void addInputData(List<Double> inputValues) {
        validateInputValues(inputValues);
        for(Neuron input:neuronsInInputLayer) {
            for(Double inputValue:inputValues) {
                input.registerSource(new StaticSource(inputValue));
            }
        }
    }

    // TODO to test and refactor
    public void learn(List<LearningData> learningDataList) {
        // validate
        validateLearningData(learningDataList);
        // learn
        for (int epoch = 0; epoch<NUMBER_OF_EPOCHS; epoch++) {
            for (LearningData learningData : learningDataList) {
                //
                addInputData(learningData.getInputValues());
                // calculating output values
                for (Neuron neuron : getNeuronsInOutputLayer()) {
                    neuron.getValue();
                }
                // expected values
                for (int i = 0; i < getNeuronsInOutputLayer().size(); i++) {
                    getNeuronsInOutputLayer().get(i).expected(learningData.getExpectedOutputData().get(i));
                }
                // correcting weights
                for (Neuron neuron : getNeuronsInOutputLayer()) {
                    neuron.correctWeights();
                }
                // cleaning temporary variables
                for (Neuron neuron : getNeuronsInOutputLayer()) {
                    neuron.clean();
                }
            }
        }
    }

    // TODO to remove
    public void learnOld(List<Double> expectedOutputValues) {
        // validate
        validateExpectedOutputValues(expectedOutputValues);
        // learn
        learnOldMultipleEpochs(expectedOutputValues, NUMBER_OF_EPOCHS);
    }

    // TODO to remove
    protected void learnOldMultipleEpochs(List<Double> expectedOutputValues, int numberOfEpochs) {
        for (int epoch = 0; epoch<numberOfEpochs; epoch++) {
            // calculating output values
            for (Neuron neuron : getNeuronsInOutputLayer()) {
                neuron.getValue();
            }
            // expected values
            for (int i = 0; i < getNeuronsInOutputLayer().size(); i++) {
                getNeuronsInOutputLayer().get(i).expected(expectedOutputValues.get(i));
            }
            // correcting weights
            for (Neuron neuron : getNeuronsInOutputLayer()) {
                neuron.correctWeights();
            }
            // cleaning temporary variables
            for (Neuron neuron : getNeuronsInOutputLayer()) {
                neuron.clean();
            }
        }
    }

    // TODO to test
    protected void validateLearningData(List<LearningData> LearningDataList) {
        if (LearningDataList == null) {
            throw new RuntimeException("Learning data cannot be null");
        }
        for (LearningData learningData : LearningDataList) {
            if (learningData == null) {
                throw new RuntimeException("LearningData value cannot be null");
            }
            if (learningData.getInputValues() == null) {
                throw new RuntimeException("InputData in LearningData cannot be null");
            }
            if (learningData.getExpectedOutputData() == null) {
                throw new RuntimeException("ExpectedOutputData in LearningData cannot be null");
            }
            for (Double d: learningData.getInputValues()) {
                if (d == null) {
                    throw new RuntimeException("Value in InputData that is in LearningData cannot be null");
                }
            }
            for (Double d: learningData.getExpectedOutputData()) {
                if (d == null) {
                    throw new RuntimeException("Value in ExpectedOutputData that is in LearningData cannot be null");
                }
            }
        }
    }

    protected void validateInputValues(List<Double> inputValues) {
        if (inputValues == null) {
            throw new RuntimeException("Input collection cannot be null");
        }
        for (Double d : inputValues) {
            if (d == null) {
                throw new RuntimeException("Input value cannot be null");
            }
        }
    }

    // TODO to remove
    protected void validateExpectedOutputValues(List<Double> expectedOutputValues) {
        if (expectedOutputValues.size() != neuronsInOutputLayer.size()) {
            throw new RuntimeException("List sizes are not equal");
        }
        for (Double d : expectedOutputValues) {
            if (d == null) {
                throw new RuntimeException("Expected output value cannot be null");
            }
        }
    }

}
