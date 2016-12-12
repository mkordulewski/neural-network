package pl.kordulewski.ai;

import org.junit.Test;

/**
 * @author Michał Kordulewski
 */
public class NeuronTest {

    @Test
    public void testRegisterSource() {
        Neuron neuron = new Neuron();
        neuron.registerSource(new StaticSource(-1));
        neuron.registerSource(new StaticSource(0));
        neuron.registerSource(new StaticSource(1));
    }

}
