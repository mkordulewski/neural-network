package pl.kordulewski.ai;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class WeightGeneratorTest {

    private WeightGenerator generator;

    @Before
    public void before() {
        generator = new WeightGenerator();
    }

    @Test
    public void testNextRandomWeight() {
        double randomWeight = generator.nextRandomWeight();
        assertThat(randomWeight).isGreaterThanOrEqualTo(-1);
        assertThat(randomWeight).isLessThanOrEqualTo(1);
    }

}
