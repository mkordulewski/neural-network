package pl.kordulewski.ai.neuralnetwork.generator;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class GeneratorTest {

    private Generator generator = new Generator();

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
}
