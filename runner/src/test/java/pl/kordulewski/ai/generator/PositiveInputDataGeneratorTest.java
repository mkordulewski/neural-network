package pl.kordulewski.ai.generator;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class PositiveInputDataGeneratorTest {

    private PositiveInputDataGenerator generator = new PositiveInputDataGenerator();

    @Test
    public void test000() {
        List<String> list = generator.generate();
        assertThat(list.size()).isGreaterThan(0);
    }
}
