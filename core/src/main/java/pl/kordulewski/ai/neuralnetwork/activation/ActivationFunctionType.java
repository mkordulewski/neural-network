package pl.kordulewski.ai.neuralnetwork.activation;

import pl.kordulewski.ai.neuralnetwork.generator.WeightGenerator;

/**
 * @author Michał Kordulewski
 */
public enum ActivationFunctionType {

    UNIPOLAR_SIGMOIDAL (new UnipolarSigmoidalFunction(), new WeightGenerator(0.0, 1.0)),
    BIPOLAR_SIGMOIDAL (new BipolarSigmoidalFunction(), new WeightGenerator(-1.0, 1.0)),
    UNIPOLAR_STEP (new UnipolarStepFunction(), new WeightGenerator(0.0, 1.0)),
    BIPOLAR_STEP (new BipolarStepFunction(), new WeightGenerator(-1.0, 1.0));

    private ActivationFunction activationFunction;
    private WeightGenerator weightGenerator;

    ActivationFunctionType(ActivationFunction activationFunction, WeightGenerator weightGenerator) {
        this.activationFunction = activationFunction;
        this.weightGenerator = weightGenerator;
    }

    public ActivationFunction getFunction() {
        return activationFunction;
    }

    public WeightGenerator getWeightGenerator() {
        return weightGenerator;
    }

}
