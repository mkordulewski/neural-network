package pl.kordulewski.ai.neuralnetwork.generator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @see WeightGenerator
 *
 * @author Michał Kordulewski
 */
public class WeightGeneratorTest {

    private WeightGenerator generator;

    @Before
    public void before() {
        generator = new WeightGenerator(0.0, 1.0);
    }

    /**
     * @see WeightGenerator#nextRandomWeight()
     */
    @Test
    public void testNextRandomWeight() {
        for (int i=0; i<1000000; i++) {
            double randomWeight = generator.nextRandomWeight();
            assertThat(randomWeight).isGreaterThanOrEqualTo(-1);
            assertThat(randomWeight).isLessThanOrEqualTo(1);
        }
    }

}
