package pl.kordulewski.ai.neuralnetwork;

import pl.kordulewski.ai.neuralnetwork.activation.ActivationFunctionType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Neuron implements Source, Serializable {

    private double learningRate = 1;
    private ActivationFunctionType activationFunctionType;
    private List<Source> sources = new ArrayList<Source>();
    private List<Double> weights = new ArrayList<Double>();
    private Double cachedOutputValue;
    private String name = "";
    private boolean corrected = false;
    private double sigma = 0.0;

    public Neuron(ActivationFunctionType activationFunctionType) {
        this(activationFunctionType, "");
    }

    public Neuron(ActivationFunctionType activationFunctionType, String name) {
        this.activationFunctionType = activationFunctionType;
        if (name != null) {
            this.name = name;
        }
    }

    public void cleanSources() {
        sources = new ArrayList<Source>();
    }

    public void registerSource(Source source) {
        if (weights.size() == sources.size()) {
            weights.add(activationFunctionType.getWeightGenerator().nextRandomWeight());
        }
        sources.add(source);
    }

    public double getValue() {
        // FIXME
//        if (cachedOutputValue != null) {
//            return cachedOutputValue;
//        }
        double input = 0;
        for (int i=0; i<sources.size();i++) {
            input += sources.get(i).getValue() * weights.get(i);
        }
        cachedOutputValue = activationFunctionType.getFunction().calculate(input);
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
                weights.set(i, weights.get(i)+ learningRate *sigma*activationFunctionType.getFunction().derivative(x) * x);
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
