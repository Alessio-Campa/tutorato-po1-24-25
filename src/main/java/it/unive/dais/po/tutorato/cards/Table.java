package it.unive.dais.po.tutorato.cards;

import java.util.ArrayList;
import java.util.List;

public class Table<C extends Card<?>> {
    private final List<C> cards = new ArrayList<>();

    public Table(){

    }

    public void add(C card){
        cards.add(card);
    }

    public List<C> getCards() {
        return new ArrayList<>(cards);
    }

    public int size(){
        return cards.size();
    }

    public void remove(C card){
        cards.remove(card);
    }

    public void remove(List<C> cards){
        for(C c : cards){
            this.remove(c);
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for(C c : cards){
                builder.append(c.toString().lines().toList().get(i));
                builder.append("  ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
