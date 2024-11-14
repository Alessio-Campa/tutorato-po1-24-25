package it.unive.dais.po.tutorato.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand<C extends Card<?>> {
    private final List<C> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public List<C> getCards(){
        return new ArrayList<>(cards);
    }

    public void addCard(C card){
        cards.add(card);
    }

    public C removeCard(int pos){
        return cards.remove(pos);
    }

    public int getSize(){
        return cards.size();
    }
}
