package pl.kordulewski.ai.neuralnetwork.activation;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class BipolarSigmoidalFunctionTest {

    private ActivationFunction func = new BipolarSigmoidalFunction();

    @Test
    public void test1() {
        double result = func.calculate(0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void test2() {
        for(double i=-10;i<0;i+=0.01) {
            double result = func.calculate(i);
            assertThat(result).isLessThan(0.5);
        }
    }

}
