package pl.kordulewski.ai.neuralnetwork.data;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class TestingDataTest {

    private TestingData testingData;

    @Test
    public void test1() {
        testingData = new TestingData(Arrays.asList(1.0, 1.0));
        assertThat(testingData.getInputValues().size()).isEqualTo(2);
    }

}
