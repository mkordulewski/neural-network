package pl.kordulewski.ai.neuralnetwork.activation;

/**
 * @author Michał Kordulewski
 */
public class ActivationFunctionLibrary {

    public static final ActivationFunction UNIPOLAR_SIGMOIDAL = new UnipolarSigmoidalFunction();
    public static final ActivationFunction BIPOLAR_SIGMOIDAL = new BipolarSigmoidalFunction();
    public static final ActivationFunction UNIPOLAR_STEP = new UnipolarStepFunction();
    public static final ActivationFunction BIPOLAR_STEP = new BipolarStepFunction();

}
