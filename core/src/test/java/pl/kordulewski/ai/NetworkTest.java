package pl.kordulewski.ai;

import org.junit.Test;

/**
 * @author Michał Kordulewski
 */
public class NetworkTest {

    @Test(expected = RuntimeException.class)
    public void testException() {
        new Network(null, null, null);
    }

}
