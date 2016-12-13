package pl.kordulewski.ai.neuralnetwork.generator;

import org.junit.Test;
import pl.kordulewski.ai.neuralnetwork.Network;

import static org.assertj.core.api.StrictAssertions.assertThat;

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
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(1);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(1);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(1);
    }

    /**
     * @see NetworkGenerator#generate(int, int, int)
     */
    @Test
    public void test333() {
        Network network = generator.generate(3,3,3);
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
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(9);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(3);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(1);
    }

}
