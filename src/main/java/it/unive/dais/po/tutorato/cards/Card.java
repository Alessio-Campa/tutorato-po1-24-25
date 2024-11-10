package it.unive.dais.po.tutorato.cards;


abstract public class Card<S> {
    final int value;
    final S suit;

    public Card(int value, S suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    abstract public String toString();
    public abstract boolean equals(Object other);
    public abstract int hashCode();

}
