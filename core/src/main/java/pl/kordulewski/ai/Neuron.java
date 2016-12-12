package pl.kordulewski.ai;

import pl.kordulewski.ai.generator.WeightGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Neuron implements Source, Serializable {

    private List<Source> sources = new ArrayList<Source>();
    private List<Double> weights = new ArrayList<Double>();
    private WeightGenerator generator = new WeightGenerator();

    public void registerSource(Source source) {
        sources.add(source);
        weights.add(generator.nextRandomWeight());
    }

    public double getValue() {
        double result = 0;
        for (int i=0; i<sources.size();i++) {
            result += sources.get(i).getValue() * weights.get(i);
        }
        return result;
    }

    public List<Source> getSources() {
        return sources;
    }

}
