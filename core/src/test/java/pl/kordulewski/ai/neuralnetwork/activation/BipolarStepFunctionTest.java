package pl.kordulewski.ai.neuralnetwork.activation;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @see BipolarStepFunction
 *
 * @author Michał Kordulewski
 */
public class BipolarStepFunctionTest {

    private ActivationFunction func = new BipolarStepFunction();

    @Test
    public void test1() {
        double result = func.calculate(-1);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void test2() {
        double result = func.calculate(0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void test3() {
        double result = func.calculate(1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void test4() {
        for(double i=-10;i<0;i+=0.01) {
            double result = func.calculate(i);
            assertThat(result).isEqualTo(-1);
        }
    }

    @Test
    public void test5() {
        for(double i=0;i<=10;i+=0.01) {
            double result = func.calculate(i);
            assertThat(result).isEqualTo(1);
        }
    }

    @Test
    public void testDerivative() {
        assertThat(func.derivative(-1)).isGreaterThanOrEqualTo(0);
        assertThat(func.derivative(0)).isGreaterThanOrEqualTo(0);
        assertThat(func.derivative(1)).isGreaterThanOrEqualTo(0);
    }

}
