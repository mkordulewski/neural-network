package pl.kordulewski.ai.neuralnetwork.activation;

/**
 * @author Michał Kordulewski
 */
public class BipolarSigmoidalFunction implements ActivationFunction {

    private static double ALPHA_INDICATOR = 1.0;

    @Override
    public double calculate(double value) {
        return (2.0/(1.0+Math.exp(-1* ALPHA_INDICATOR *value)))-1.0;
    }

}
