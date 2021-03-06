package tdd.utils;

public class Money implements Expression {

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

    public Expression times(int multiplier){
        return new Money(amount * multiplier,currency);
    }

    public String currency() {
        return currency;
    }

    public Expression plus(Expression addend){
        return new Sum(this,addend);
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Money reduce(Bank bank, String to){
        int rate  = bank.rate(currency,to);
        return new Money(amount/rate,to);
    }
}

