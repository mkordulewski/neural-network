package pl.kordulewski.ai;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

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
        double value = neuron.getValue();
    }

}
