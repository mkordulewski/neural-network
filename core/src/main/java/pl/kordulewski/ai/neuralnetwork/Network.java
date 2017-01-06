package pl.kordulewski.ai.neuralnetwork;

import pl.kordulewski.ai.neuralnetwork.data.LearningData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Michał Kordulewski
 */
public class Network implements Serializable {

    private int numberOfEpochs = 1000;
    private boolean shuffleLearningData = false;

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

    public void addInputData(List<Double> inputValues) {
        validateInputValues(inputValues);
        if (inputValues.size() != getNeuronsInInputLayer().size())
            throw new RuntimeException("Number of input values must be the same as number of neurons in the input layer.");
        for (int i = 0; i < inputValues.size(); i++) {
            getNeuronsInInputLayer().get(i).cleanSources();
            getNeuronsInInputLayer().get(i).registerSource(new StaticSource(inputValues.get(i)));
        }
    }

    public void learn(List<LearningData> inputLearningDataList) {
        // validate
        validateLearningData(inputLearningDataList);
        // copy
        List<LearningData> learningDataList = new ArrayList<>(inputLearningDataList);
        // learn
        for (int epoch = 0; epoch<numberOfEpochs; epoch++) {
            // shuffle list
            if (shuffleLearningData) {
                long seed = System.nanoTime();
                Collections.shuffle(learningDataList, new Random(seed));
            }
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

}
