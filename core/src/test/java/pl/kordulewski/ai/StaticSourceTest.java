package pl.kordulewski.ai;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Michał Kordulewski
 */
public class StaticSourceTest {

    @Test
    public void test_1() {
        Source source = new StaticSource(-1);
        assertThat(source.getValue()).isEqualTo(-1);
    }

    @Test
    public void test0() {
        Source source = new StaticSource(0);
        assertThat(source.getValue()).isEqualTo(0);
    }

    @Test
    public void test1() {
        Source source = new StaticSource(1);
        assertThat(source.getValue()).isEqualTo(1);
    }

}
