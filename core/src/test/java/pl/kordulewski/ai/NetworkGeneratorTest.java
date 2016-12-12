package pl.kordulewski.ai;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class NetworkGeneratorTest {

    private NetworkGenerator generator = new NetworkGenerator();

    @Test
    public void test000() {
        Network network = generator.generate(0,0,0);
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(0);
        assertThat(network.getNeuronsInHiddenLayer().size()).isEqualTo(0);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(0);
    }

}
