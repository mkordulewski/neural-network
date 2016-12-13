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
    private String binary;

    @Test
    public void testConvertStringToBinary() {
        binary = converter.convertStringToBinary("");
        assertThat(binary).isNotNull();
        assertThat(binary).isEmpty();
        assertThat(binary.length()).isEqualTo(0);
    }

    @Test
    public void testConvertStringToBinary1Char() {
        binary = converter.convertStringToBinary("a");
        assertThat(binary).isNotNull();
        assertThat(binary).isNotEmpty();
        assertThat(binary.length()).isEqualTo(8);
    }

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

    @Test
    public void test1Character() {
        result = converter.convert("a");
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(8);
    }

    @Test
    public void test2Characters() {
        result = converter.convert("ab");
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(16);
    }

    @Test
    public void test3Characters() {
        result = converter.convert("abc");
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(24);
    }

    @Test
    public void test4Characters() {
        result = converter.convert("abcd");
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(32);
    }

}
