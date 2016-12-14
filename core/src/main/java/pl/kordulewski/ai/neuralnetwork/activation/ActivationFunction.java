package pl.kordulewski.ai.neuralnetwork.activation;

/**
 * @author Michał Kordulewski
 */
public interface ActivationFunction {

    double calculate(double value);

    double derivative(double value);

}
