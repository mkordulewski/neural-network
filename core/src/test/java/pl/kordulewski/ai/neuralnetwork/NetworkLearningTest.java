package pl.kordulewski.ai.neuralnetwork;

import org.junit.Test;
import pl.kordulewski.ai.neuralnetwork.data.LearningData;
import pl.kordulewski.ai.neuralnetwork.generator.NetworkGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.failBecauseExceptionWasNotThrown;

/**
 * @see NetworkGenerator
 *
 * @author Michał Kordulewski
 */
public class NetworkLearningTest {

    private NetworkGenerator generator = new NetworkGenerator();

    /**
     * @see NetworkGenerator#generate(int...)
     */
    @Test
    public void test111() {
        Network network = generator.generate(1,1,1);
        List<Double> inputValues = Arrays.asList(-1.0);
        List<Double> expectedOutputData = Arrays.asList(-1.0);
        LearningData learningData = new LearningData(inputValues, expectedOutputData);
        network.learn(Arrays.asList(learningData));
        assertThat(network.getNeuronsInInputLayer().size()).isEqualTo(1);
        assertThat(network.getNeuronsInLayer(1).size()).isEqualTo(1);
        assertThat(network.getNeuronsInOutputLayer().size()).isEqualTo(1);
    }

}
