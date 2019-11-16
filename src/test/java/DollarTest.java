import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import tdd.utils.Dollar;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(3);
        assertEquals(15,five.amount);
    }
}
