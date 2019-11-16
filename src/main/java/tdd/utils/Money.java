package tdd.utils;

public abstract class Money {

    protected String currency;
    int amount;

    public Money( int amount,String currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money dollar(int amount){
        return new Dollar(amount,"USD");
    }

    public static Money franc(int amount){
        return new Franc(amount,"CHF");
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount
                && getClass().equals(obj.getClass());
    }

    public abstract Money times(int multiplier);

    public String currency() {
        return currency;
    }
}

