package pl.kordulewski.ai.neuralnetwork;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @see StaticSource
 *
 * @author Michał Kordulewski
 */
public class StaticSourceTest {

    private StaticSource source;

    /**
     * @see StaticSource#StaticSource(double)
     */
    @Test
    public void test_1() {
        source = new StaticSource(-1);
        assertThat(source.getValue()).isEqualTo(-1);
    }

    /**
     * @see StaticSource#StaticSource(double)
     */
    @Test
    public void test0() {
        source = new StaticSource(0);
        assertThat(source.getValue()).isEqualTo(0);
    }

    /**
     * @see StaticSource#StaticSource(double)
     */
    @Test
    public void test1() {
        source = new StaticSource(1);
        assertThat(source.getValue()).isEqualTo(1);
    }

}
