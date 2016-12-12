package pl.kordulewski.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michał Kordulewski
 */
public class Neuron implements Source {

    private List<Source> sources = new ArrayList<Source>();

    public void registerSource(Source source) {
        sources.add(source);
    }

    public double getValue() {
        // TODO
        return 0;
    }
}
