package pl.kordulewski.ai.neuralnetwork;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class NetworkTest {

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
