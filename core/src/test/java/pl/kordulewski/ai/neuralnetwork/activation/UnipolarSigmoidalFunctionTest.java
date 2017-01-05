package pl.kordulewski.ai.neuralnetwork.activation;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * @see UnipolarSigmoidalFunction
 *
 * @author Michał Kordulewski
 */
public class UnipolarSigmoidalFunctionTest {

    private ActivationFunction func = new UnipolarSigmoidalFunction();

    @Test
    public void test1() {
        assertThat(func.calculate(-100)).isLessThan(0.0000000000000000001);
        assertThat(func.calculate(-100)).isGreaterThan(0.0);
        assertThat(func.calculate(-10)).isLessThan(0.0001);
        assertThat(func.calculate(-10)).isGreaterThan(0.0);
        assertThat(func.calculate(-5)).isEqualTo(0.0066928509242848554);
        assertThat(func.calculate(-1)).isEqualTo(0.2689414213699951);
        assertThat(func.calculate(0)).isEqualTo(0.5);
        assertThat(func.calculate(1)).isEqualTo(0.7310585786300049);
        assertThat(func.calculate(5)).isEqualTo(0.9933071490757153);
        assertThat(func.calculate(10)).isLessThan(1.0000);
        assertThat(func.calculate(10)).isGreaterThan(0.9999);
        assertThat(func.calculate(100)).isLessThanOrEqualTo(1.0);
        assertThat(func.calculate(100)).isGreaterThan(0.9999999999999999);
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

    @Test
    public void testDerivative() {
        assertThat(func.derivative(0)).isGreaterThanOrEqualTo(0.25);
    }

}
