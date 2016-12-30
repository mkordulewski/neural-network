package pl.kordulewski.ai.neuralnetwork.activation;

/**
 * @author Michał Kordulewski
 */
public enum ActivationFunctionType {

    UNIPOLAR_SIGMOIDAL (new UnipolarSigmoidalFunction()),
    BIPOLAR_SIGMOIDAL (new BipolarSigmoidalFunction()),
    UNIPOLAR_STEP (new UnipolarStepFunction()),
    BIPOLAR_STEP (new BipolarStepFunction());

    private ActivationFunction activationFunction;

    ActivationFunctionType(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public ActivationFunction getFunction() {
        return activationFunction;
    }

}
