import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import tdd.utils.Bank;
import tdd.utils.Expression;
import tdd.utils.Money;
import tdd.utils.Sum;

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
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduce = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10),reduce);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five,sum.augend);
        assertEquals(five,sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(7),result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1),"USD");
        assertEquals(Money.dollar(1),result);

    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.franc(2),"USD");
        assertEquals(Money.dollar(1),result);
    }

    @Test
    public void testArrayEquals() {
        assertArrayEquals(new Object[] {"abc"},new Object[]{"abc"});
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1,new Bank().rate("USD","USD"));
    }
}
