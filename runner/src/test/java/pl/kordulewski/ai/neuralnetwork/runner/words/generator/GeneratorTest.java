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

    @Test
    public void generateRandomChar() {
        char letter;
        for (int i=0; i<10000; i++) {
            letter = generator.generateRandomChar();
            assertThat(letter).isGreaterThanOrEqualTo(Character.toChars(65)[0]);
            assertThat(letter).isLessThanOrEqualTo(Character.toChars(97+25)[0]);
        }
    }

    @Test
    public void generateRandomLetter() {
        String letter;
        for (int i=0; i<10000; i++) {
            letter = generator.generateRandomLetter();
            assertThat(letter.length()).isEqualTo(1);
        }
    }

    @Test
    public void replaceChar() {
        String input = "1234";
        assertThat(new Generator().replaceChar(input, 0, 'X')).isEqualTo("X234");
        assertThat(new Generator().replaceChar(input, 1, 'X')).isEqualTo("1X34");
        assertThat(new Generator().replaceChar(input, 2, 'X')).isEqualTo("12X4");
        assertThat(new Generator().replaceChar(input, 3, 'X')).isEqualTo("123X");
    }

}
