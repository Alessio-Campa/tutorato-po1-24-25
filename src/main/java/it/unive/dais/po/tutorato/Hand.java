package it.unive.dais.po.tutorato;


import it.unive.dais.po.tutorato.cards.CardIta;

public class Hand {
    private CardIta[] cards;
    private boolean[] used;

    Hand(CardIta[] cards){
        this.cards = cards;
        this.used = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            used[i] = false;
        }
    }

    CardIta play(int pos){ //TODO: add errors
        if (used[pos]){
            return null;
        }
        used[pos] = true;
        return cards[pos];
    }

    public boolean[] getUsed() {
        return used.clone();
    }
}
