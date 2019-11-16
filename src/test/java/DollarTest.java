import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import tdd.utils.Dollar;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10),five.times(2));
        assertEquals(new Dollar(15),five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
}
