package it.unive.dais.po.tutorato;


public class Hand {
    private Card[] cards;
    private boolean[] used;

    Hand(Card[] cards){
        this.cards = cards;
        this.used = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            used[i] = false;
        }
    }

    Card play(int pos){ //TODO: add errors
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
