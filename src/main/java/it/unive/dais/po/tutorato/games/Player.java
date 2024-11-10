package it.unive.dais.po.tutorato.games;

import it.unive.dais.po.tutorato.cards.Card;
import it.unive.dais.po.tutorato.cards.Hand;

import java.util.List;

public abstract class Player<C extends Card<?>> {
    String name;
    Hand<C> hand;

    protected Player(){
        this.hand = new Hand<>();
    }

    public Player(String name){
        this();
        this.name = name;
    }

    protected void init(){
        hand = new Hand<>();
    }

    public final String getName() {
        return name;
    }

    final void addCard(C card){
        hand.addCard(card);
    }

    public final C playCard(int i){
        return hand.removeCard(i);
    }

    public final int getHandSize(){
        return hand.getSize();
    }

    public final boolean isHandEmpty(){
        return getHandSize() == 0;
    }
}
