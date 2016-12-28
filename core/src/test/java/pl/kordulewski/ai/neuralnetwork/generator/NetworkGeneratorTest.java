package pl.kordulewski.ai.neuralnetwork.generator;

import org.junit.Test;
import pl.kordulewski.ai.neuralnetwork.Network;
import pl.kordulewski.ai.neuralnetwork.Neuron;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.failBecauseExceptionWasNotThrown;

/**
 * @author Michał Kordulewski
 */
public class NetworkGeneratorTest {

    private NetworkGenerator generator = new NetworkGenerator();

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test
    public void test000() {
        Network network = generator.generate(0,0,0);
        List<Double> expectedOutputValues = Arrays.asList();
        network.learn(expectedOutputValues);
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(0);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(0);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(0);
    }

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test
    public void test111() {
        Network network = generator.generate(1,1,1);
        List<Double> expectedOutputValues = Arrays.asList(1.0);
        network.learn(expectedOutputValues);
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(1);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(1);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(1);
    }

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test
    public void test331() {
        Network network = generator.generate(3,3,1);
        List<Double> expectedOutputValues = Arrays.asList(1.0);
        network.learn(expectedOutputValues);
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(3);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(3);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(1);
    }

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test
    public void test333() {
        Network network = generator.generate(3,3,3);
        List<Double> expectedOutputValues = Arrays.asList(1.0,1.0,1.0);
        network.learn(expectedOutputValues);
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(3);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(3);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(3);
    }

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test
    public void test931() {
        Network network = generator.generate(9,3,1);
        List<Double> expectedOutputValues = Arrays.asList(1.0);
        network.learn(expectedOutputValues);
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(9);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(3);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(1);
    }

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test(expected = RuntimeException.class)
    public void testNotEqualListSizesA() {
        Network network = generator.generate(9,3,1);
        List<Double> expectedOutputValues = Arrays.asList();
        network.learn(expectedOutputValues);
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test(expected = RuntimeException.class)
    public void testNotEqualListSizesB() {
        Network network = generator.generate(9,3,1);
        List<Double> expectedOutputValues = Arrays.asList(1.0, 1.0);
        network.learn(expectedOutputValues);
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test(expected = RuntimeException.class)
    public void testExpectedValueIsNull() {
        Network network = generator.generate(9,3,2);
        List<Double> expectedOutputValues = Arrays.asList(1.0, null);
        network.learn(expectedOutputValues);
    }

}
