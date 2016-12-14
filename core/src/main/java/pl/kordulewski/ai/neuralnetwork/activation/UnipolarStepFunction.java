package pl.kordulewski.ai.neuralnetwork.activation;

/**
 * @author Michał Kordulewski
 */
public class UnipolarStepFunction implements ActivationFunction {

    @Override
    public double calculate(double value) {
        if (value>=0)
            return 1;
        else
            return 0;
    }

    @Override
    public double derivative(double value) {
        // TODO
        return 0;
    }

}
