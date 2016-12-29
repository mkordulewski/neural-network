package pl.kordulewski.ai.neuralnetwork;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see Network
 *
 * @author Michał Kordulewski
 */
public class NetworkTest {

    /**
     * @see Network#Network(List, List, List)
     * @see Network#addInputData(List)
     */
    @Test
    public void testAddInputData() {
        List<Neuron> neuronsInInputLayer = Arrays.asList(new Neuron());
        List<Neuron> neuronsInHiddenLayer = Arrays.asList(new Neuron());
        List<Neuron> neuronsInOutputLayer = Arrays.asList(new Neuron());
        Network network = new Network(neuronsInInputLayer, neuronsInHiddenLayer, neuronsInOutputLayer);
        List<Double> inputData = Arrays.asList(0.0);
        network.addInputData(inputData);
    }

    /**
     * @see Network#Network(List, List, List)
     * @see Network#addInputData(List)
     */
    @Test(expected = RuntimeException.class)
    public void validateInputValues1() {
        List<Neuron> neuronsInInputLayer = Arrays.asList(new Neuron());
        List<Neuron> neuronsInHiddenLayer = Arrays.asList(new Neuron());
        List<Neuron> neuronsInOutputLayer = Arrays.asList(new Neuron());
        Network network = new Network(neuronsInInputLayer, neuronsInHiddenLayer, neuronsInOutputLayer);
        network.addInputData(null);
    }

    /**
     * @see Network#Network(List, List, List)
     * @see Network#addInputData(List)
     */
    @Test(expected = RuntimeException.class)
    public void validateInputValues2() {
        List<Neuron> neuronsInInputLayer = Arrays.asList(new Neuron(), new Neuron());
        List<Neuron> neuronsInHiddenLayer = Arrays.asList(new Neuron(), new Neuron());
        List<Neuron> neuronsInOutputLayer = Arrays.asList(new Neuron());
        Network network = new Network(neuronsInInputLayer, neuronsInHiddenLayer, neuronsInOutputLayer);
        List<Double> inputData = Arrays.asList(1.0, null);
        network.addInputData(inputData);
    }

    /**
     * @see Network#Network(List, List, List)
     */
    @Test(expected = RuntimeException.class)
    public void testException() {
        new Network(null, null, null);
    }

    /**
     * @see Network#Network(List, List, List)
     */
    @Test(expected = RuntimeException.class)
    public void testException1() {
        new Network(null, new ArrayList<Neuron>(), new ArrayList<Neuron>());
    }

    /**
     * @see Network#Network(List, List, List)
     */
    @Test(expected = RuntimeException.class)
    public void testException2() {
        new Network(new ArrayList<Neuron>(), null, new ArrayList<Neuron>());
    }

    /**
     * @see Network#Network(List, List, List)
     */
    @Test(expected = RuntimeException.class)
    public void testException3() {
        new Network(new ArrayList<Neuron>(), new ArrayList<Neuron>(), null);
    }

}
