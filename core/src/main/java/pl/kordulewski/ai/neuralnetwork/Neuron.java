package pl.kordulewski.ai.neuralnetwork;

import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunction;
import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionLibrary;
import pl.kordulewski.ai.neuralnetwork.activation.BipolarSigmoidalFunction;
import pl.kordulewski.ai.neuralnetwork.generator.WeightGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Neuron implements Source, Serializable {

    private static final double LEARNING_RATE = 1;

    private ActivationFunction activationFunction = ActivationFunctionLibrary.UNIPOLAR_SIGMOIDAL;
    private List<Source> sources = new ArrayList<Source>();
    private List<Double> weights = new ArrayList<Double>();
    private Double cachedOutputValue;
    private String name = "";
    private boolean corrected = false;
    private double sigma = 0.0;

    public Neuron() {
    }

    public Neuron(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void cleanSources() {
        sources = new ArrayList<Source>();
    }

    public void registerSource(Source source) {
        if (weights.size() == sources.size()) {
            weights.add(WeightGenerator.getInstance().nextRandomWeight());
        }
        sources.add(source);
    }

    public double getValue() {
        if (cachedOutputValue != null) {
            return cachedOutputValue;
        }
        double input = 0;
        for (int i=0; i<sources.size();i++) {
            input += sources.get(i).getValue() * weights.get(i);
        }
        cachedOutputValue = activationFunction.calculate(input);
        return cachedOutputValue;
    }

    protected void expected(double expectedValue) {
        sigma(expectedValue - getValue());
    }

    protected void sigma(double sigma) {
        // add to own sigma
        this.sigma += sigma;
        // pass weighted sigma to neurons are your sources
        for (int i=0; i<sources.size();i++) {
            if (sources.get(i) instanceof Neuron) {
                ((Neuron) sources.get(i)).sigma(sigma * weights.get(i));
            }
        }
    }

    protected void correctWeights() {
        if (!corrected) {
            for (int i=0; i<sources.size();i++) {
                if (sources.get(i) instanceof Neuron) {
                    ((Neuron) sources.get(i)).correctWeights();
                }
            }
            // new weights
            for (int i=0; i<weights.size();i++) {
                double x = sources.get(i).getValue();
                weights.set(i, weights.get(i)+LEARNING_RATE*sigma*activationFunction.derivative( x ) * x);
            }
            corrected = true;
        }
    }

    protected void clean() {
        if (!isClean()) {
            cleanYourself();
            cleanCascade();
        }
    }

    protected boolean isClean() {
        return corrected==false && sigma == 0.0 && cachedOutputValue==null;
    }

    protected void cleanYourself() {
        corrected = false;
        sigma = 0.0;
        cachedOutputValue = null;
    }

    protected void cleanCascade() {
        for (int i = 0; i < sources.size(); i++) {
            if (sources.get(i) instanceof Neuron) {
                ((Neuron) sources.get(i)).clean();
            }
        }
    }

    protected List<Source> getSources() {
        return sources;
    }

}
