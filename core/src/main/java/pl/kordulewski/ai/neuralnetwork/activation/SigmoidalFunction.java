package pl.kordulewski.ai.neuralnetwork.activation;

/**
 * @author Michał Kordulewski
 */
public class SigmoidalFunction implements ActivationFunction {

    @Override
    public double calculate(double value) {
        return 1.0/(1.0+Math.exp(-1*value));
    }

}
