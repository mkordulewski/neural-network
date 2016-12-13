package pl.kordulewski.ai.neuralnetwork.activation;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class SigmoidalFunctionTest {

    private SigmoidalFunction func = new SigmoidalFunction();

    @Test
    public void test() {
        double result = func.calculate(0);
        assertThat(result).isEqualTo(0.5);
    }

}
