import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import tdd.utils.Money;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class DollarTest {

    @Test
    public void testCurrency() {
        assertEquals("USD",Money.dollar(1).currency());
        assertEquals("CHF",Money.franc(1).currency());
    }

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10),five.times(2));
        assertEquals(Money.dollar(15),five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10),five.times(2));
        assertEquals(Money.franc(15),five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
}
