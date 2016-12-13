package pl.kordulewski.ai.neuralnetwork;

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

    @Test
    public void testGetSources0() {
        Neuron neuron = new Neuron();
        assertThat(neuron.getSources().size()).isEqualTo(0);
    }

    @Test
    public void testGetSources() {
        Neuron neuron = new Neuron();
        neuron.registerSource(new StaticSource(-1));
        neuron.registerSource(new StaticSource(0));
        neuron.registerSource(new StaticSource(1));
        assertThat(neuron.getSources().size()).isEqualTo(3);
    }

}
