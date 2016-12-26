package pl.kordulewski.ai.neuralnetwork.activation;

/**
 * @author Michał Kordulewski
 */
public class UnipolarSigmoidalFunction implements ActivationFunction {

    private static double ALPHA_INDICATOR = 1.0;

    @Override
    public double calculate(double value) {
        return 1.0/(1.0+Math.exp(-1* ALPHA_INDICATOR *value));
    }

    @Override
    public double derivative(double value) {
        return (ALPHA_INDICATOR * Math.exp(ALPHA_INDICATOR * value)) / Math.pow(Math.exp(ALPHA_INDICATOR * value) + 1.0, 2);
    }

}
