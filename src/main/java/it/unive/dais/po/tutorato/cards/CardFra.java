package it.unive.dais.po.tutorato.cards;

import it.unive.dais.po.tutorato.suits.SuitFra;

public class CardFra extends Card<SuitFra>{

    public CardFra(int value, SuitFra suit) {
        super(value, suit);
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
