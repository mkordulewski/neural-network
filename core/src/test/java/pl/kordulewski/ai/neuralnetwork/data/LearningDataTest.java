package pl.kordulewski.ai.neuralnetwork.data;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.failBecauseExceptionWasNotThrown;

/**
 * @see LearningData
 * @see LearningData#getInputValues()
 * @see LearningData#getExpectedOutputData()
 * @see LearningData#LearningData(List, List)
 *
 * @author Michał Kordulewski
 */
public class LearningDataTest {

    private LearningData learningData;

    @Test
    public void test0() {
        learningData = new LearningData(Arrays.asList(), Arrays.asList());
        assertThat(learningData.getInputValues().size()).isEqualTo(0);
        assertThat(learningData.getExpectedOutputData().size()).isEqualTo(0);
    }

    @Test
    public void test1() {
        learningData = new LearningData(Arrays.asList(1.0), Arrays.asList(1.0));
        assertThat(learningData.getInputValues().size()).isEqualTo(1);
        assertThat(learningData.getExpectedOutputData().size()).isEqualTo(1);
    }

    @Test
    public void test2() {
        learningData = new LearningData(Arrays.asList(1.0, 0.0), Arrays.asList(1.0, 0.0));
        assertThat(learningData.getInputValues().size()).isEqualTo(2);
        assertThat(learningData.getExpectedOutputData().size()).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void testNull01() {
        learningData = new LearningData(null, Arrays.asList(1.0));
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    @Test(expected = RuntimeException.class)
    public void testNull02() {
        learningData = new LearningData(Arrays.asList(1.0), null);
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    @Test(expected = RuntimeException.class)
    public void testNull11() {
        learningData = new LearningData(Arrays.asList(null), Arrays.asList(1.0));
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    @Test(expected = RuntimeException.class)
    public void testNull12() {
        learningData = new LearningData(Arrays.asList(1.0), Arrays.asList(null));
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    @Test(expected = RuntimeException.class)
    public void testNull31() {
        learningData = new LearningData(Arrays.asList(1.0, null), Arrays.asList(1.0, 0.0));
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

    @Test(expected = RuntimeException.class)
    public void testNull32() {
        learningData = new LearningData(Arrays.asList(1.0, 0.0), Arrays.asList(1.0, null));
        failBecauseExceptionWasNotThrown(RuntimeException.class);
    }

}
