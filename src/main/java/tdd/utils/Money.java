package tdd.utils;

class Money {

    int amount;


    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount;
    }
}
