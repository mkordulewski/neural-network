package pl.kordulewski.ai;

/**
 * @author Michał Kordulewski
 */
public class StaticSource implements Source {

    private double value = 0;

    public StaticSource(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
