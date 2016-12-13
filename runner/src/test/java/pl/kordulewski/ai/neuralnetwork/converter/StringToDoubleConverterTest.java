package pl.kordulewski.ai.neuralnetwork.converter;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class StringToDoubleConverterTest {

    private StringToDoubleConverter converter = new StringToDoubleConverter();
    private List<Double> result;

    @Test
    public void testNull() {
        result = converter.convert(null);
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    public void test() {
        result = converter.convert("");
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(0);
    }

}
