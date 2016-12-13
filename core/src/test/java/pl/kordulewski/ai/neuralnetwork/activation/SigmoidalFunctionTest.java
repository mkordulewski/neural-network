package pl.kordulewski.ai.neuralnetwork.activation;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @author Michał Kordulewski
 */
public class SigmoidalFunctionTest {

    private ActivationFunction func = new SigmoidalFunction();

    @Test
    public void test1() {
        double result = func.calculate(0);
        assertThat(result).isEqualTo(0.5);
    }

    @Test
    public void test2() {
        for(double i=-10;i<0;i+=0.01) {
            double result = func.calculate(i);
            assertThat(result).isLessThan(0.5);
        }
    }

    @Test
    public void test3() {
        for(double i=0;i<=10;i+=0.01) {
            double result = func.calculate(i);
            assertThat(result).isGreaterThanOrEqualTo(0.5);
        }
    }

}
