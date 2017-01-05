package pl.kordulewski.ai.neuralnetwork.activation;

/**
 * @author Michał Kordulewski
 */
public class UnipolarSigmoidalFunction implements ActivationFunction {

    private double alpha = 1.0;

    @Override
    public double calculate(double value) {
        return 1.0/(1.0+Math.exp(-1* alpha *value));
    }

    @Override
    public double derivative(double value) {
        return (alpha * Math.exp(alpha * value)) / Math.pow(Math.exp(alpha * value) + 1.0, 2);
    }

}
