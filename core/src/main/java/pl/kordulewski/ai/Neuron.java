package pl.kordulewski.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Neuron implements Source {

    private List<Source> sources = new ArrayList<Source>();
    private List<Double> weights = new ArrayList<Double>();

    public void registerSource(Source source) {
        sources.add(source);
        weights.add(0.0);
    }

    public double getValue() {
        // TODO
        return 0;
    }
}
