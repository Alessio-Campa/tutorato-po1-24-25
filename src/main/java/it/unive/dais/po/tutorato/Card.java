package it.unive.dais.po.tutorato;

public class Card {
    int value;
    Suit suit;

    Card(int val, Suit suit) {
        this.value = val;
        this.suit = suit;
    }

    Card(Card c){ // copy constructor
        this(c.value, c.suit);
    }


    public static void main(String[] args) {
        Card setteBello = new Card(7, Suit.DENARI);
        Card reBello = new Card(10, Suit.DENARI);
    }
}