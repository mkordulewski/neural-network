package pl.kordulewski.ai;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Michał Kordulewski
 */
public class StaticSourceTest {

    @Test
    public void test() {
        Source source = new StaticSource(0);
        assertThat(source.getValue()).isEqualTo(0);
    }

}
