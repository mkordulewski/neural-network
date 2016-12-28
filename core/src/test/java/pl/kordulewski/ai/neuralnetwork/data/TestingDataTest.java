package pl.kordulewski.ai.neuralnetwork.data;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.failBecauseExceptionWasNotThrown;

/**
 * @see TestingData
 * @see TestingData#getInputValues()
 * @see TestingData#TestingData(List)
 *
 * @author Michał Kordulewski
 */
public class TestingDataTest {

    private TestingData testingData;

    @Test
    public void test1() {
        testingData = new TestingData(Arrays.asList());
        assertThat(testingData.getInputValues().size()).isEqualTo(0);
    }

    @Test
    public void test2() {
        testingData = new TestingData(Arrays.asList(1.0));
        assertThat(testingData.getInputValues().size()).isEqualTo(1);
    }

    @Test
    public void test3() {
        testingData = new TestingData(Arrays.asList(1.0, 1.0));
        assertThat(testingData.getInputValues().size()).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void testNull1() {
        testingData = new TestingData(null);
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    @Test(expected = RuntimeException.class)
    public void testNull2() {
        testingData = new TestingData(Arrays.asList(null));
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    @Test(expected = RuntimeException.class)
    public void testNull3() {
        testingData = new TestingData(Arrays.asList(1.0, null));
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

}
