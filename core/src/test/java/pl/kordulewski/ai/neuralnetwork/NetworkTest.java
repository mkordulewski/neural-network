package pl.kordulewski.ai.neuralnetwork;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Michał Kordulewski
 */
public class NetworkTest {

    @Test(expected = RuntimeException.class)
    public void testException() {
        new Network(null, null, null);
    }

    @Test(expected = RuntimeException.class)
    public void testException1() {
        new Network(null, new ArrayList<Neuron>(), new ArrayList<Neuron>());
    }

    @Test(expected = RuntimeException.class)
    public void testException2() {
        new Network(new ArrayList<Neuron>(), null, new ArrayList<Neuron>());
    }

    @Test(expected = RuntimeException.class)
    public void testException3() {
        new Network(new ArrayList<Neuron>(), new ArrayList<Neuron>(), null);
    }

}
