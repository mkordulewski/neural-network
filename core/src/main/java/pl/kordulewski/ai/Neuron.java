package pl.kordulewski.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Neuron implements Source {

    private List<Source> sources = new ArrayList<Source>();
    private List<Double> weights = new ArrayList<Double>();
    private WeightGenerator generator = new WeightGenerator();

    public void registerSource(Source source) {
        sources.add(source);
        weights.add(generator.nextRandomWeight());
    }

    public double getValue() {
        // TODO
        return 0;
    }
}
