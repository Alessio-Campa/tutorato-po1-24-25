package it.unive.dais.po.tutorato.cards;

import it.unive.dais.po.tutorato.suits.SuitIta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckIta extends Deck<CardIta>{

    private DeckIta(int n, List<SuitIta> suits) {
        super();
        for (SuitIta suit : suits) {
            for (int j = 0; j < n; j++) {
                deck.add(new CardIta(j + 1, suit));
            }
        }
        Collections.shuffle(deck);
    }

    public DeckIta(){
        this(10, List.of(SuitIta.BASTONI, SuitIta.COPPE, SuitIta.DENARI, SuitIta.SPADE));
    }
}
