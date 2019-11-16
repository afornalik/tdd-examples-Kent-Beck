package tdd.utils;

public abstract class Money {

    int amount;

    public static Money dollar(int amount){
        return new Dollar(amount);
    }

    public static Money franc(int amount){
        return new Franc(amount);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount
                && getClass().equals(obj.getClass());
    }

    public abstract Money times(int multiplier);
}