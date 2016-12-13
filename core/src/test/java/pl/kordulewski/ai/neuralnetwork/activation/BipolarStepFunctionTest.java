package pl.kordulewski.ai.neuralnetwork.activation;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class BipolarStepFunctionTest {

    private BipolarStepFunction func = new BipolarStepFunction();

    @Test
    public void test1() {
        double result = func.calculate(-1);
        assertThat(result).isEqualTo(-1);
    }

}
