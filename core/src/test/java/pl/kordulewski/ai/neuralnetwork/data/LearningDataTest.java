package pl.kordulewski.ai.neuralnetwork.data;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

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

}
