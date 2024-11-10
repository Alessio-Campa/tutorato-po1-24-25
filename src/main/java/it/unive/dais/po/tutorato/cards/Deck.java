package it.unive.dais.po.tutorato.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Deck<C extends Card<?>> {
    protected List<C> deck;
    protected int pos = 0;

    public Deck() {
        deck = new ArrayList<>();
    }

    public C getTopCard(){
        return deck.get(pos++);
    }

    public boolean isEmpty(){
        return pos == deck.size();
    }
}
