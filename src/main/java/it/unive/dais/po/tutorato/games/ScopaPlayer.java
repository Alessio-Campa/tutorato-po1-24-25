package it.unive.dais.po.tutorato.games;

import it.unive.dais.po.tutorato.cards.CardIta;
import it.unive.dais.po.tutorato.suits.SuitIta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScopaPlayer extends Player<CardIta> {
    private List<CardIta> stash;
    private int points;
    private int scope = 0;

    public ScopaPlayer() {
        super();
        this.stash = new ArrayList<>();
        this.points = 0;
    }

    public ScopaPlayer(String name) {
        super(name);
        this.stash = new ArrayList<>();
        this.points = 0;
    }

    protected void init(){
        super.init();
        stash = new ArrayList<>();
        this.scope = 0;
    }

    public CardIta playTurn(List<CardIta> table){
        return playCard(0);
    }

    final void addStash(List<CardIta> cards){
        stash.addAll(cards);
    }
    final void addStash(CardIta card){
        stash.add(card);
    }

    final int getPoints(){
        return points;
    }

    final void addPoints(int p){
        points += p;
    }

    final void addScopa(){
        scope++;
    }

    public final int getScope() {
        return scope;
    }

    public final int getPrimieraPoints() {
        int primiera = 0;
        for(SuitIta suit : SuitIta.values()){
            Optional<Integer> suitPrimiera = stash
                    .stream()
                    .filter(card -> card.getSuit() == suit)
                    .map(CardIta::getPrimieraValue)
                    .max(Integer::compare);
            if (suitPrimiera.isEmpty()) return 0;
            primiera += suitPrimiera.get();
        }
        return primiera;
    }

    public final int calcTurnPoints(){
        int turnPoints = 0;
        if (stash.size() > 20) {
            System.out.println(this.getName() + " got 1 'Mazzo' point");
            turnPoints++;
        }
        if (stash.stream().filter(card -> card.getSuit() == SuitIta.DENARI).toList().size() > 5){
            System.out.println(this.getName() + " got 1 'Denari' point");
            turnPoints++;
        }
        if (stash.contains(new CardIta(7, SuitIta.DENARI))){
            System.out.println(this.getName() + " got 1 '7 Bello' point");
            turnPoints++;
        }
        if (stash.contains(new CardIta(10, SuitIta.DENARI))){
            System.out.println(this.getName() + " got 1 '10 Bello' point");
            turnPoints++;
        }
        if (scope > 0){
            System.out.println(this.getName() + " made " + scope + " 'scopa' point" + (scope == 1 ? "" : "s"));
            turnPoints += scope;
        }

        return turnPoints;
    }

    public int chooseCards(List<List<CardIta>> cards){
        return 0;
    }

    public void inform(CardIta card){}
}
