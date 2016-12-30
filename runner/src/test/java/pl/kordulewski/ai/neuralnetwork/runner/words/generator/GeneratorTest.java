package pl.kordulewski.ai.neuralnetwork.runner.words.generator;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class GeneratorTest {

    private Generator generator = new Generator();

    /**
     * @see Generator#generatePositiveInputData()
     */
    @Test
    public void test000() {
        List<String> list = generator.generatePositiveInputData();
        assertThat(list).isNotNull();
        assertThat(list.size()).isGreaterThan(0);
        for(String s:list) {
            assertThat(s).isNotNull();
            assertThat(s).isNotEmpty();
        }
    }

    /**
     * @see Generator#generateListOfDoubles(int, double)
     */
    @Test
    public void testGenerateListOfDoubles() {
        List<Double> list = generator.generateListOfDoubles(0, 0.0);
        assertThat(list).isNotNull();
        assertThat(list).isEmpty();
        assertThat(list.size()).isEqualTo(0);
    }

    /**
     * @see Generator#generateListOfDoubles(int, double)
     */
    @Test
    public void testGenerateListOfDoublesLoop() {
        for(int size: new int[]{1,2,3}) {
            for(double value: new double[]{-1.0, 0.0, 1.0}) {
                List<Double> list = generator.generateListOfDoubles(size, value);
                assertThat(list).isNotNull();
                assertThat(list).isNotEmpty();
                assertThat(list.size()).isEqualTo(size);
                for(Double d:list) {
                    assertThat(d).isEqualTo(value);
                }
            }
        }

    }

}
