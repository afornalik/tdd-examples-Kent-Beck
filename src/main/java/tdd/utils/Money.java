package tdd.utils;

public class Money {

    protected String currency;
    int amount;

    public Money( int amount,String currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money dollar(int amount){
        return new Money(amount,"USD");
    }

    public static Money franc(int amount){
        return new Money(amount,"CHF");
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount
                && currency().equals(money.currency());
    }

    public Money times(int multiplier){
        return new Money(amount * multiplier,currency);
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}

